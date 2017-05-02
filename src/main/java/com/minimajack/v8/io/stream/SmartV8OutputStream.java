package com.minimajack.v8.io.stream;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;

public abstract class SmartV8OutputStream
    extends OutputStream
{
    protected V8FileAttribute cachedV8FileAttributes;

    protected V8File file;

    protected File realFile;

    protected Path realPath;

    public SmartV8OutputStream( V8File file )
        throws IOException
    {
        this.file = file;
        this.cachedV8FileAttributes = file.getAttributes();
        getOrCreateFile();
    }

    protected final void getOrCreateFile()
        throws IOException
    {
        String name = cachedV8FileAttributes.getName().trim();
        String path = file.getContext().getPath();
        File file = new File( path );
        realFile = new File( path + File.separator + name );
        if ( !realFile.exists() )
        {
            file.mkdirs();
            if ( !realFile.createNewFile() )
            {
                throw new IOException( "Can't create output file" );
            }

        }
        this.realPath = realFile.toPath();
    }

    public Path getPath()
    {
        return realPath;
    }
}

package com.minimajack.v8.io.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;

public class RawFileOutputStream
    extends OutputStream
{

    private V8File file;

    private File fileReal;

    private BufferedOutputStream realStream;

    private V8FileAttribute cachedV8FileAttributes;

    public RawFileOutputStream( V8File file )
        throws IOException
    {
        super();
        this.file = file;
        this.cachedV8FileAttributes = file.getAttributes();
        getOrCreateFile();
        this.realStream = new BufferedOutputStream( new FileOutputStream( fileReal ) );
    }

    private final void getOrCreateFile()
        throws IOException
    {
        String name = cachedV8FileAttributes.getName().trim();
        String path = file.getContext().getPath();
        File file = new File( path );
        file.mkdirs();
        file = new File( path + File.separator + name + ".txt" );
        if ( !file.exists() )
        {
            file.createNewFile();
        }
        this.fileReal = file;
    }

    @Override
    public void flush()
        throws IOException
    {
        realStream.flush();
    }

    @Override
    public void close()
        throws IOException
    {
        this.flush();
        realStream.close();
    }

    @Override
    public void write( byte[] b, int off, int len )
        throws IOException
    {
        realStream.write( b, off, len );
    }

    @Override
    public void write( byte[] b )
        throws IOException
    {
        realStream.write( b );
    }

    @Override
    public void write( int b )
        throws IOException
    {
        realStream.write( b );

    }
}

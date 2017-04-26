package com.minimajack.v8.io.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;

public class FileCacheOutputStream
    extends CacheOutput
{

    private V8File file;

    private File fileReal;

    private long lastModifyVirtual;

    private long createdVirtual;

    private BufferedOutputStream realStream;

    private long lastModifyReal;

    private V8FileAttribute cachedV8FileAttributes;

    public FileCacheOutputStream( V8File file )
        throws IOException
    {
        super();
        this.file = file;
        this.cachedV8FileAttributes = file.getAttributes();
        lastModifyVirtual = cachedV8FileAttributes.getModifyDate().getTime();
        createdVirtual = cachedV8FileAttributes.safeGetCreationDate().getTime();
        getOrCreateFile();
        Path p = this.fileReal.toPath();
        FileTime attrs = Files.getLastModifiedTime( p, LinkOption.NOFOLLOW_LINKS );
        this.lastModifyReal = attrs.toMillis();
        if ( !isInCache() )
        {
            this.realStream = new BufferedOutputStream( new FileOutputStream( fileReal ) );
        }

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
    public boolean isInCache()
    {
        return lastModifyVirtual == lastModifyReal;
    }

    @Override
    public void flush()
        throws IOException
    {
        if ( !isInCache() )
        {
            realStream.flush();
        }
    }

    @Override
    public void close()
        throws IOException
    {
        if ( !isInCache() )
        {
            this.flush();
            realStream.close();
            Path p = fileReal.toPath();
            Files.setAttribute( p, "creationTime", FileTime.fromMillis( createdVirtual ) );
            Files.setAttribute( p, "lastModifiedTime", FileTime.fromMillis( lastModifyVirtual ) );
        }
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

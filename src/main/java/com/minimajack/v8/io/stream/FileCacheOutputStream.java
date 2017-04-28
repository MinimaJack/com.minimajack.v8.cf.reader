package com.minimajack.v8.io.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

import com.minimajack.v8.format.V8File;

public class FileCacheOutputStream
    extends CacheOutput
{

    private long lastModifyVirtual;

    private long createdVirtual;

    private long lastModifyReal;

    private BufferedOutputStream realStream;

    public FileCacheOutputStream( V8File file )
        throws IOException
    {
        super( file );
        lastModifyVirtual = cachedV8FileAttributes.getModifyDate().getTime();
        createdVirtual = cachedV8FileAttributes.safeGetCreationDate().getTime();
        FileTime attrs = Files.getLastModifiedTime( realPath, LinkOption.NOFOLLOW_LINKS );
        this.lastModifyReal = attrs.toMillis();
        if ( !isInCache() )
        {
            this.realStream = new BufferedOutputStream( new FileOutputStream( realFile ) );
        }

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
            Path p = realFile.toPath();
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

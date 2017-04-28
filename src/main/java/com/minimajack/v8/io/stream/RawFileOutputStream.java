package com.minimajack.v8.io.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.minimajack.v8.format.V8File;

public class RawFileOutputStream
    extends SmartV8OutputStream
{

    private BufferedOutputStream realStream;

    public RawFileOutputStream( V8File file )
        throws IOException
    {
        super( file );
        this.realStream = new BufferedOutputStream( new FileOutputStream( realFile ) );
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

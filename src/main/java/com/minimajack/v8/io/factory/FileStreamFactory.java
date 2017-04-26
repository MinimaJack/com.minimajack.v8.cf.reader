package com.minimajack.v8.io.factory;

import java.io.IOException;
import java.io.OutputStream;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.RawFileOutputStream;

public class FileStreamFactory
    implements StreamFactory
{

    public OutputStream createStream( V8File file )
        throws IOException
    {
        return new RawFileOutputStream( file );
    }
}

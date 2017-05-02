package com.minimajack.v8.io.factory.impl;

import java.io.IOException;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.StreamFactory;
import com.minimajack.v8.io.stream.RawFileOutputStream;
import com.minimajack.v8.io.stream.SmartV8OutputStream;

public class FileStreamFactory
    implements StreamFactory
{

    @Override
    public SmartV8OutputStream createStream( V8File file )
        throws IOException
    {
        return new RawFileOutputStream( file );
    }
}

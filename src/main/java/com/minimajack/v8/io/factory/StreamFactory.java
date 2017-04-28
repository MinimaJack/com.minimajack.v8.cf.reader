package com.minimajack.v8.io.factory;

import java.io.IOException;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.SmartV8OutputStream;

public interface StreamFactory
{
    public SmartV8OutputStream createStream( V8File file )
        throws IOException;
}

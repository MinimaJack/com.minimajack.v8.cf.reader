package com.minimajack.v8.io.stream;

import java.io.IOException;

import com.minimajack.v8.format.V8File;

public abstract class CacheOutput
    extends SmartV8OutputStream
{
    public CacheOutput( V8File file )
        throws IOException
    {
        super( file );
    }

    public abstract boolean isInCache();
}

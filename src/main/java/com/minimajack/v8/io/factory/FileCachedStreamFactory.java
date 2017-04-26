package com.minimajack.v8.io.factory;

import java.io.IOException;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.CacheOutput;
import com.minimajack.v8.io.stream.FileCacheOutputStream;

public class FileCachedStreamFactory
    implements CachedStreamFactory
{

    public CacheOutput createStream( V8File file )
        throws IOException
    {
        return new FileCacheOutputStream( file );
    }
}

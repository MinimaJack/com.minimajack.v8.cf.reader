package com.minimajack.v8.io.factory;

import java.io.IOException;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.CacheOutput;

public interface CachedStreamFactory
    extends StreamFactory
{

    @Override
    public CacheOutput createStream( V8File file )
        throws IOException;
}

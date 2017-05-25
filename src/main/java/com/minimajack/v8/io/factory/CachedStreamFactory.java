package com.minimajack.v8.io.factory;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.CacheOutput;

import java.io.IOException;

public interface CachedStreamFactory extends StreamFactory {

  @Override
  CacheOutput createStream(V8File file) throws IOException;
}

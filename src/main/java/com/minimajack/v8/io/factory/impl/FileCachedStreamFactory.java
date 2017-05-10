package com.minimajack.v8.io.factory.impl;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.CachedStreamFactory;
import com.minimajack.v8.io.stream.CacheOutput;
import com.minimajack.v8.io.stream.FileCacheOutputStream;

import java.io.IOException;

public class FileCachedStreamFactory implements CachedStreamFactory {

  @Override
  public CacheOutput createStream(final V8File file) throws IOException {
    return new FileCacheOutputStream(file);
  }
}

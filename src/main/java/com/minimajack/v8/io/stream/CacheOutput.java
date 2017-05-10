package com.minimajack.v8.io.stream;

import com.minimajack.v8.format.V8File;

import java.io.IOException;

public abstract class CacheOutput extends SmartV8OutputStream {

  public CacheOutput(final V8File file) throws IOException {
    super(file);
  }

  public abstract boolean isInCache();
}

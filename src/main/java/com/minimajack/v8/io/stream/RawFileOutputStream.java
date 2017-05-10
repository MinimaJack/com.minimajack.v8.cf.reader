package com.minimajack.v8.io.stream;

import com.minimajack.v8.format.V8File;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RawFileOutputStream extends SmartV8OutputStream {

  private final BufferedOutputStream realStream;

  public RawFileOutputStream(final V8File file) throws IOException {
    super(file);
    this.realStream = new BufferedOutputStream(new FileOutputStream(this.realFile));
  }

  @Override
  public void flush() throws IOException {
    this.realStream.flush();
  }

  @Override
  public void close() throws IOException {
    flush();
    this.realStream.close();
  }

  @Override
  public void write(final byte[] byteArray, final int off, final int len) throws IOException {
    this.realStream.write(byteArray, off, len);
  }

  @Override
  public void write(final byte[] byteArray) throws IOException {
    this.realStream.write(byteArray);
  }

  @Override
  public void write(final int byteArray) throws IOException {
    this.realStream.write(byteArray);

  }
}

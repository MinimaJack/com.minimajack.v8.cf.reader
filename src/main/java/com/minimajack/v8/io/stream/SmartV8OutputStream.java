package com.minimajack.v8.io.stream;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

public abstract class SmartV8OutputStream extends OutputStream {

  protected V8FileAttribute cachedV8FileAttributes;

  protected V8File file;

  protected File realFile;

  protected Path realPath;

  public SmartV8OutputStream(final V8File file) throws IOException {
    this.file = file;
    this.cachedV8FileAttributes = file.getAttributes();
    getOrCreateFile();
  }

  protected final void getOrCreateFile() throws IOException {
    final String name = this.cachedV8FileAttributes.getName().trim();
    final String path = this.file.getContext().getPath();
    final File file = new File(path);
    this.realFile = new File(path + File.separator + name);
    if (!this.realFile.exists()) {
      file.mkdirs();
      if (!this.realFile.createNewFile()) {
        throw new IOException("Can't create output file");
      }

    }
    this.realPath = this.realFile.toPath();
  }

  public Path getPath() {
    return this.realPath;
  }
}

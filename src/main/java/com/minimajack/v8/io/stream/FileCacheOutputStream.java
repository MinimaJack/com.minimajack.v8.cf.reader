package com.minimajack.v8.io.stream;

import com.minimajack.v8.format.V8File;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class FileCacheOutputStream extends CacheOutput {

  private final long lastModifyVirtual;

  private final long createdVirtual;

  private final long lastModifyReal;

  private BufferedOutputStream realStream;

  public FileCacheOutputStream(final V8File file) throws IOException {
    super(file);
    this.lastModifyVirtual = this.cachedV8FileAttributes.getModifyDate().getTime();
    this.createdVirtual = this.cachedV8FileAttributes.safeGetCreationDate().getTime();
    final FileTime attrs = Files.getLastModifiedTime(this.realPath, LinkOption.NOFOLLOW_LINKS);
    this.lastModifyReal = attrs.toMillis();
    if (!isInCache()) {
      this.realStream = new BufferedOutputStream(new FileOutputStream(this.realFile));
    }

  }

  @Override
  public boolean isInCache() {
    return this.lastModifyVirtual == this.lastModifyReal;
  }

  @Override
  public void flush() throws IOException {
    if (!isInCache()) {
      this.realStream.flush();
    }
  }

  @Override
  public void close() throws IOException {
    if (!isInCache()) {
      flush();
      this.realStream.close();
      final Path p = this.realFile.toPath();
      Files.setAttribute(p, "creationTime", FileTime.fromMillis(this.createdVirtual));
      Files.setAttribute(p, "lastModifiedTime", FileTime.fromMillis(this.lastModifyVirtual));
    }
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

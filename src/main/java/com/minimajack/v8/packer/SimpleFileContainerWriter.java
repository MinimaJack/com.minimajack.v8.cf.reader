package com.minimajack.v8.packer;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.Container;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;
import com.minimajack.v8.io.metrix.ChunkSizeResolver;
import com.minimajack.v8.io.writer.BlockHeaderChunkWriter;
import com.minimajack.v8.io.writer.ContainerWriter;
import com.minimajack.v8.io.writer.RawChunkWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

@Deprecated
public class SimpleFileContainerWriter extends ContainerWriter {

  boolean packed;

  final ConcurrentLinkedDeque<File> fileList = new ConcurrentLinkedDeque<>();

  public SimpleFileContainerWriter(final File path, final boolean packed) {
    if (path == null) {
      throw new InvalidParameterException("Path can't be null");
    }
    final int version = 0;
    final HashMap<String, File> fileNames = new HashMap<String, File>();
    final File[] fileList = path.listFiles();
    if (fileList == null) {
      throw new InvalidParameterException("Path must be a file");
    }
    for (final File file : fileList) {
      fileNames.put(file.getName().toLowerCase(), file);
    }
    fileNames.keySet().stream().map(n -> {
      if (n.endsWith(".txt")) {
        return n.substring(0, n.lastIndexOf('.'));
      } else {
        return n;
      }
    }).sorted().forEach(t -> {
      if (fileNames.containsKey(t)) {
        this.fileList.add(fileNames.get(t));
      } else {
        this.fileList.add(fileNames.get(t + ".txt"));
      }
    });

    this.packed = packed;
    final Container container = new Container();
    container.setVersion(version);
    setContainer(container);
    setFileSystemSize(this.fileList.size() * V8File.FILE_DESCRIPTION_SIZE);

  }

  @Override
  public boolean hasData() {
    return super.hasData() || (this.fileList.size() > 0);
  }

  @Override
  public void getDataToWrite() {
    final File currentFile = this.fileList.poll();
    final V8File v8file = new V8File();
    final Path p = currentFile.toPath();
    long createdVirtual = 0;
    long lastModifyVirtual = 0;
    try {
      createdVirtual = ((FileTime) Files.getAttribute(p, "creationTime")).toMillis();
      lastModifyVirtual = ((FileTime) Files.getAttribute(p, "lastModifiedTime")).toMillis();
    } catch (final IOException e2) {
      e2.printStackTrace();
    }

    final V8FileAttribute attributes = new V8FileAttribute();
    attributes.setPosition(getPosition());
    attributes.setName(getRealName(currentFile));
    attributes.setCreationDate(new Date(createdVirtual));
    attributes.setModifyDate(new Date(lastModifyVirtual));
    final int attrSize = attributes.getPayloadSize();
    attributes.setDocSize(attrSize);

    final BlockHeaderChunkWriter atrChunkWriter = new BlockHeaderChunkWriter(attributes);
    atrChunkWriter.setSizeResolver(new ChunkSizeResolver(attrSize));
    atrChunkWriter.setFullSize(attrSize);

    attachAdditionData(atrChunkWriter);

    v8file.setAttributes(attributes);

    byte[] data = null;
    if (currentFile.isDirectory()) {
      SimpleFileContainerWriter fscw = new SimpleFileContainerWriter(currentFile, false);
      fscw.writeAllData();
      data = fscw.getRawData();
      fscw = null;
    } else {
      try (FileInputStream fis = new FileInputStream(currentFile)) {
        data = ByteStreams.toByteArray(fis);
      } catch (final IOException e) {
        throw new RuntimeException("Can't read file data" + currentFile);
      }
    }
    if (this.packed) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final DeflaterOutputStream dataStream =
          new DeflaterOutputStream(baos, new Deflater(6, true));
      try {
        dataStream.write(data);
        dataStream.finish();
        dataStream.flush();
      } catch (final IOException e1) {
        e1.printStackTrace();
      }
      data = baos.toByteArray();
    }

    v8file.setBodyAddress(getPosition());
    final RawChunkWriter bodyChunkWriter = new RawChunkWriter(data);
    if (this.packed) {
      bodyChunkWriter.setSizeResolver(new ChunkSizeResolver(Math.max(512, data.length)));
    } else {
      bodyChunkWriter.setSizeResolver(new ChunkSizeResolver(data.length));
    }

    attachAdditionData(bodyChunkWriter);

    try {
      this.write(v8file);
    } catch (final IOException e) {
      throw new RuntimeException("Cant write v8File");
    }

  }

  private String getRealName(final File file) {
    final String fileName = file.getName();
    if (file.isDirectory()) {
      return fileName;
    } else {
      return fileName.substring(0, fileName.length() - 4);
    }
  }
}

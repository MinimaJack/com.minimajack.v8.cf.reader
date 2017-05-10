package com.minimajack.v8.parser.impl;

import com.google.common.io.ByteStreams;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.StreamFactory;
import com.minimajack.v8.io.factory.impl.FileStreamFactory;
import com.minimajack.v8.io.stream.SmartV8OutputStream;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.ProjectTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class VirtualFileParserTask extends ParserTask {

  private static final long serialVersionUID = -3177536977013094515L;

  final transient Logger logger = LoggerFactory.getLogger(VirtualFileParserTask.class);

  private transient StreamFactory streamFactory = new FileStreamFactory();

  private transient V8File file;

  public VirtualFileParserTask(final V8File file) {
    this.file = file;
  }

  @Override
  protected ProjectTree compute() {
    ProjectTree result;
    Path path = null;
    try (SmartV8OutputStream fos = this.streamFactory.createStream(this.file);
        InputStream dataStream = this.file.getBody().getDataStream()) {
      path = fos.getPath();
      ByteStreams.copy(dataStream, fos);
      result = new ProjectTree(fos.getPath(), FileType.FILE);
    } catch (final IOException e) {
      this.logger.error("Error in FileReader", e);
      result = new ProjectTree(path, FileType.ERROR);

    }
    result.setName(this.file.getContext().getName());
    return result;

  }

}

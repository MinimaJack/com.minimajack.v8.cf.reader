package com.minimajack.v8.parser.impl;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.model.Context;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.project.ProjectTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ForkJoinPool;

public class FileParserTask extends ParserTask {

  private static final long serialVersionUID = 3593273381663000741L;

  final transient Logger logger = LoggerFactory.getLogger(FileParserTask.class);

  public transient Container container;

  private final String filePath;

  private final String destPath;

  private final Strategy strategy;

  public FileParserTask(final String filePath, final String destPath, final Strategy strategy) {
    this.filePath = filePath;
    this.destPath = destPath;
    this.strategy = strategy;
  }

  @Override
  public ProjectTree compute() {
    ProjectTree result = new ProjectTree();
    try (RandomAccessFile aFile = new RandomAccessFile(this.filePath, "r");
        FileChannel inChannel = aFile.getChannel()) {
      final MappedByteBuffer buffer =
          inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
      buffer.order(ByteOrder.LITTLE_ENDIAN);

      final Context root = new Context();
      root.setName(this.destPath);
      if (!this.filePath.endsWith(".hbk")) {
        root.setInflated(true);
      }
      root.setReader(ContainerParserTask.class);

      this.container = new Container(buffer);
      this.container.setContext(root);
      final ContainerParserTask reader = new ContainerParserTask();
      reader.setContext(root);
      reader.setContainer(this.container);
      reader.setStrategy(this.strategy);
      result = ForkJoinPool.commonPool().invoke(reader);

    } catch (final IOException e) {
      this.logger.error("Error while parse root container: {}", e.getMessage());
    } catch (final OutOfMemoryError e) {
      this.logger.error("Out of memory, can't map file to memory", e);
    }
    return result;
  }
}

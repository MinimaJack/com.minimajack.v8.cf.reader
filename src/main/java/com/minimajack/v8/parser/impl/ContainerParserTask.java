package com.minimajack.v8.parser.impl;

import com.google.common.io.ByteStreams;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.io.StrategyHolder;
import com.minimajack.v8.io.reader.AbstractReader;
import com.minimajack.v8.model.Context;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.ProjectTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ContainerParserTask extends ParserTask implements AbstractReader, StrategyHolder {

  private static final long serialVersionUID = -4612951038206319516L;

  final transient Logger logger = LoggerFactory.getLogger(ContainerParserTask.class);

  private transient Context context;

  private transient Container container;

  private Strategy strategy;

  @Override
  public Context getContext() {
    return this.context;
  }

  @Override
  public void setContext(final Context context) {
    this.context = context;
  }

  @Override
  public void read() {
    try {
      ForkJoinPool.commonPool().invoke(this);
    } catch (final Exception e) {
      this.logger.error("Error while parsing container", e);
    }

  }

  @Override
  public void setContainer(final Container container) {
    this.container = container;
  }

  @Override
  public ProjectTree compute() {
    final LinkedList<ParserTask> tasks = new LinkedList<ParserTask>();
    final ProjectTree result =
        new ProjectTree(new File(getContext().getPath()).toPath(), FileType.CONTAINER);
    result.setName(this.context.getName());
    try {
      this.container.read();
      this.container.getFileSystem().read();
      this.container.getFileSystem().readFiles();
      final List<V8File> v8list = this.container.getFileSystem().getV8FileList();
      for (final V8File f : v8list) {
        if (f.isContainer()) {
          final Context childContext =
              f.getContext().createChildContext(f.getAttributes().getName().trim());
          final Container childContainer =
              new Container(ByteStreams.toByteArray(f.getBody().getInputStream()));
          childContainer.setContext(childContext);
          final ContainerParserTask reader = new ContainerParserTask();
          reader.setStrategy(getStrategy());
          reader.setContext(childContext);
          reader.setContainer(childContainer);
          tasks.add(reader);
        } else {
          switch (getStrategy()) {
            case MODIFYDATE: {
              tasks.add(new VirtualCachedFileParserTask(f));
              break;
            }
            case NONCACHE: {
              tasks.add(new VirtualFileParserTask(f));
              break;
            }
            default: {
              break;
            }
          }

        }
      }

      final Collection<ParserTask> taskResults = ForkJoinTask.invokeAll(tasks);
      for (final ParserTask parserTask : taskResults) {
        result.addChild(parserTask.getRawResult());
      }
    } catch (final IOException e) {
      this.logger.error("Error while parsing container", e);
    } catch (final OutOfMemoryError e) {
      this.logger.error("Out of memory", e);
    }
    this.container.cleanUp();
    return result;
  }

  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }

  @Override
  public void setStrategy(final Strategy strategy) {
    this.strategy = strategy;

  }

}

package com.minimajack.v8.code.impl;

import com.minimajack.v8.code.Processor;
import com.minimajack.v8.project.ProjectTree;

import java.nio.file.Path;

public class RelativizeProcessor implements Processor<ProjectTree> {

  private final Path path;

  public RelativizeProcessor(final Path path) {
    this.path = path;
  }

  @Override
  public ProjectTree process(final ProjectTree tree) {
    final ProjectTree current = tree;
    current.setPath(this.path.relativize(current.getRawPath().toAbsolutePath()).toString());
    for (final ProjectTree pt : current.getChild()) {
      process(pt);
    }
    return tree;
  }

}

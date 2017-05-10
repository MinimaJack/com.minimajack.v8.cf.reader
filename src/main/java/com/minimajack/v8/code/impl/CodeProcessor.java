package com.minimajack.v8.code.impl;

import com.minimajack.v8.code.Processor;
import com.minimajack.v8.project.ProjectTree;

import java.util.LinkedList;

public class CodeProcessor implements Processor<ProjectTree> {

  LinkedList<Processor<ProjectTree>> processors = new LinkedList<Processor<ProjectTree>>();

  @Override
  public ProjectTree process(ProjectTree tree) {
    for (final Processor<ProjectTree> processor : this.processors) {
      tree = processor.process(tree);
    }
    return tree;
  }

  public void addProcessor(final Processor<ProjectTree> processor) {
    this.processors.add(processor);
  }
}

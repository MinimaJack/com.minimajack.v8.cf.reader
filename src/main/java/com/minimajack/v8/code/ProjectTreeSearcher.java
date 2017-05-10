package com.minimajack.v8.code;

import com.google.common.io.ByteStreams;

import com.minimajack.v8.project.ProjectTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

public abstract class ProjectTreeSearcher implements Processor<ProjectTree> {

  Path path;

  public ProjectTreeSearcher(final Path path) {
    this.path = path;
  }

  public ByteBuffer getFileBuffer(final ProjectTree tree, final String name) {
    final ProjectTree file = findFileByName(tree, name);
    if (file != null) {
      ByteBuffer bb = null;
      try (
          FileInputStream fis = new FileInputStream(this.path + File.separator + file.getPath())) {
        bb = ByteBuffer.wrap(ByteStreams.toByteArray(fis));
        bb.position(3);
      } catch (final IOException e) {
        e.printStackTrace();
      }
      return bb;
    }
    return null;
  }

  public ProjectTree findFileByName(final ProjectTree tree, final String name) {
    final ProjectTree current = tree;
    ProjectTree result = null;
    if (tree.name.equals(name)) {
      result = tree;
    } else {
      for (final ProjectTree pt : current.getChild()) {
        result = findFileByName(pt, name);
        if (result != null) {
          break;
        }
      }
    }
    return result;

  }
}

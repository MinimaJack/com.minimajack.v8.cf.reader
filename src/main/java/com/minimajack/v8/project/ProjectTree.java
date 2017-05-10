package com.minimajack.v8.project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "type", "name", "path", "child" })
public class ProjectTree {

  @XmlTransient
  private Path path;

  @XmlElement
  public FileType type;

  @XmlElement
  public String name;

  @XmlTransient
  public ArrayList<ProjectTree> child = new ArrayList<ProjectTree>();

  public ProjectTree() {

  }

  public ProjectTree(final Path path, final FileType type) {
    super();
    this.path = path;
    this.type = type;
  }

  @XmlElement
  public String getPath() {
    return this.path.toString();
  }

  @XmlTransient
  public Path getRawPath() {
    return this.path;
  }

  public void setPath(final String path) {
    this.path = Paths.get(path);
  }

  @XmlTransient
  public FileType getType() {
    return this.type;
  }

  public void setType(final FileType type) {
    this.type = type;
  }

  @XmlElement
  public ArrayList<ProjectTree> getChild() {
    return this.child;
  }

  public void addChild(final ProjectTree child) {
    this.child.add(child);
  }

  @XmlTransient
  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

}

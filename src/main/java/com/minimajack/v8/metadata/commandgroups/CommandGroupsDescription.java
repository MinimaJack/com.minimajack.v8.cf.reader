package com.minimajack.v8.metadata.commandgroups;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommandGroupsDescription {

  public Integer version;
  public CommandGroupsBlock info;
  public List<V8InnerClass> sections;
}

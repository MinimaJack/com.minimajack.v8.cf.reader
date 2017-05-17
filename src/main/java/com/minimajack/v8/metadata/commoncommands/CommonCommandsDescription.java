package com.minimajack.v8.metadata.commoncommands;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonCommandsDescription {

  public Integer version;
  public CommonCommandsBlock info;
  public List<V8InnerClass> sections;
}

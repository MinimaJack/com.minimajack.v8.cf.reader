package com.minimajack.v8.metadata.configuration.main;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class MainConfigurationBlockInfo {

  public Integer type;

  public MainConfigurationBlockInnerInfo sno;

  public List<V8ClassObject> sections;
}

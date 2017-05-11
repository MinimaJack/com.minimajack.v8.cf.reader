package com.minimajack.v8.metadata.configuration.main;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class MainConfigurationBlockInfo {

  public Integer type;

  public MainConfigurationBlockInnerInfo sno;

  public List<V8InnerClass> sections;
}

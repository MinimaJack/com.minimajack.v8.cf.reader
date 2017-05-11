package com.minimajack.v8.metadata.configuration.businessprocesses;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class BusinessProcessesConfigurationBlock {

  public Integer version;

  public BusinessProcessesConfigurationBlockInfo info;

  public List<V8InnerClass> sections;
}

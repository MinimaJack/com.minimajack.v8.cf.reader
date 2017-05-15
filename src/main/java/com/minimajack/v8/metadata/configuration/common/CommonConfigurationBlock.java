package com.minimajack.v8.metadata.configuration.common;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonConfigurationBlock {

  public Integer version;

  public ConfigurationSimpleDescription sd;

  public List<V8InnerClass> sections;
}

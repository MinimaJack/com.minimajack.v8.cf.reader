package com.minimajack.v8.metadata.enums;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class EnumDescription {

  public Integer version;

  public EnumDescriptionBlock edb;

  public List<V8InnerClass> sections;
}

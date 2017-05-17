package com.minimajack.v8.metadata.commonattributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonAttributesDescription {

  public Integer version;
  public CommonAttributesBlock info;
  public List<V8InnerClass> sections;
}

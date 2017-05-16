package com.minimajack.v8.metadata.functionaloption.params;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class FunctionalOptionParamsDescription {

  public Integer version;
  public FunctionalOptionParamsBlock fopb;
  public List<V8InnerClass> sections;
}

package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class ChoiceParameters extends V8InnerClass {

  public Integer version;

  public List<ChoiceParameter> parameters;

}

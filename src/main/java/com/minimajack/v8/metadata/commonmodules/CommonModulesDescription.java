package com.minimajack.v8.metadata.commonmodules;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonModulesDescription {

  public Integer version;

  public CommonModulesDescriptionInner formInnerDescription;

  public List<V8InnerClass> sections;

}

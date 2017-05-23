package com.minimajack.v8.metadata.commonforms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonFormDescription {

  public Integer version;

  public CommonFormDescriptionInner info;

  public List<V8InnerClass> sections;

}

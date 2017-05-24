package com.minimajack.v8.metadata.interfaces;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class InterfacesDescription {

  public Integer version;
  public InterfacesBlock info;
  public List<V8InnerClass> sections;
}

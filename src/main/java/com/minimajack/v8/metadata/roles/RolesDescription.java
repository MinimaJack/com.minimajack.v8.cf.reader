package com.minimajack.v8.metadata.roles;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class RolesDescription {

  public Integer version;

  public RolesDescriptionBlock v8mn;
  public List<V8InnerClass> sections;
}

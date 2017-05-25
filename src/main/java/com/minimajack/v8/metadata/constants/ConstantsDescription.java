package com.minimajack.v8.metadata.constants;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class ConstantsDescription {

  public Integer version;
  public ConstantsDescriptionBlock info;
  public List<V8ClassObject> sections;
}

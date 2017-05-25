package com.minimajack.v8.metadata.definedtypes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class DefinedTypesDescription {

  public Integer version;

  public DefinedTypesBlock info;
  public List<V8ClassObject> sections;
}

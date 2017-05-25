package com.minimajack.v8.metadata.businessprocesses;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
@V8Version
public class BusinessProcessesDescription {

  public Integer version;
  public BusinessProcessesDescriptionBlock info;
  public List<V8ClassObject> sections;
}

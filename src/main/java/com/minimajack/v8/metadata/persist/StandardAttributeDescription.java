package com.minimajack.v8.metadata.persist;

import com.minimajack.v8.annotation.V8Class;

import java.util.List;

@V8Class
public class StandardAttributeDescription {

  public Integer version;
  public List<SomePersistObject> listObjects;
}

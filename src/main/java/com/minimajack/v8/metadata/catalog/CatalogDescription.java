package com.minimajack.v8.metadata.catalog;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class CatalogDescription {

  public Integer version;
  public CatalogDescriptionBlock info;
  public List<V8ClassObject> sections;
}

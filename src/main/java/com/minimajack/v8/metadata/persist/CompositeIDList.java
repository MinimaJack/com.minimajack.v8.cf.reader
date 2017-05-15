package com.minimajack.v8.metadata.persist;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.type.TypeValue;

import java.util.List;

@V8Class
public class CompositeIDList {

  public Integer version;
  public List<TypeValue> composites;
}

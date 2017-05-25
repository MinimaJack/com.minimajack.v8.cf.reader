package com.minimajack.v8.metadata.external.unknown;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.type.TypeValue;

import java.util.List;

@V8Class
public class MetadataObjectPropertyValueCollection {

  public Integer version;
  public List<TypeValue> items;

  public int count() {
    return this.items.size();
  }

  public boolean Contains(final TypeValue object) {
    return this.items.contains(object);
  }
}

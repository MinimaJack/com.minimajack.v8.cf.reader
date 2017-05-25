package com.minimajack.v8.metadata.external.type.impl;

import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

public class InnerClassTypeValue extends TypeValue {

  public V8InnerClass value;

  @Override
  public V8InnerClass getValue() {
    return value;
  }
}

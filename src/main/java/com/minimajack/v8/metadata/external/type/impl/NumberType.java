package com.minimajack.v8.metadata.external.type.impl;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.inner.enums.V8Type;
import com.minimajack.v8.utility.AnyData;

@V8Class
public class NumberType extends TypeValue {

  public V8Type type;

  public AnyData defaultValue;

}

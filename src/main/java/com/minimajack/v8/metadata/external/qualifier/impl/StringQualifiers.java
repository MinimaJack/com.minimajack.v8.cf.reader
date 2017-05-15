package com.minimajack.v8.metadata.external.qualifier.impl;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.inner.enums.V8Type;

@V8Class
public class StringQualifiers extends Qualifiers {

  public V8Type type;

  @Required(required = false)
  public Integer required;

  @Required(required = false)
  public Integer q2;
}

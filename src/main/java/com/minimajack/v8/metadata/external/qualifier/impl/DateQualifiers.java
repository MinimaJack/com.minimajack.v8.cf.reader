package com.minimajack.v8.metadata.external.qualifier.impl;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.DateFractions;
import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;

@V8Class
public class DateQualifiers extends Qualifiers {

  public V8Type type;

  @Required(required = false)
  public DateFractions date = DateFractions.ANY;

}

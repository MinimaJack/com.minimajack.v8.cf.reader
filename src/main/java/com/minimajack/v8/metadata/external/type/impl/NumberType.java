package com.minimajack.v8.metadata.external.type.impl;

import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.utility.AnyData;

import java.math.BigDecimal;

public class NumberType extends TypeValue {

  public AnyData value;

  @Override
  public Number getValue() {
    return new BigDecimal(value.getData());
  }

}

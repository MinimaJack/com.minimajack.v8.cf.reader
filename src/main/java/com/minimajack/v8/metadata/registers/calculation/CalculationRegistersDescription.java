package com.minimajack.v8.metadata.registers.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class CalculationRegistersDescription {

  public Integer version;
  public CalculationRegistersBlock info;
  public List<V8ClassObject> sections;

}

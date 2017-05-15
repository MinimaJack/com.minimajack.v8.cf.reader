package com.minimajack.v8.metadata.registers.accumulation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class AccumulationRegistersDescription {

  public Integer version;
  public AccumulationRegistersBlock arb;
  public List<V8InnerClass> sections;

}

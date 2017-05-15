package com.minimajack.v8.metadata.registers.information;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class InformationRegistersDescription {

  public Integer version;
  public InformationRegistersBlock arb;
  public List<V8InnerClass> sections;

}

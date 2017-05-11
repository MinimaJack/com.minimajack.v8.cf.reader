package com.minimajack.v8.metadata.configuration.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class CalculationConfigurationBlock {

  public Integer version;

  public CalculationConfigurationBlockInfo info;

  public List<V8InnerClass> sections;
}

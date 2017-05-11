package com.minimajack.v8.metadata.innerclass.configuration.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.calculation.CalculationConfigurationBlock;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.UUID;

@V8Class
public class CalculationConfiguraionMetaData extends V8InnerClass {

  public UUID type;

  public CalculationConfigurationBlock innerType;

}

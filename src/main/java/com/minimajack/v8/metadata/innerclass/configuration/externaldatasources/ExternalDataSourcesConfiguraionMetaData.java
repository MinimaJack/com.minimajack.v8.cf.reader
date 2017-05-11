package com.minimajack.v8.metadata.innerclass.configuration.externaldatasources;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.calculation.CalculationConfigurationBlock;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.UUID;

@V8Class
public class ExternalDataSourcesConfiguraionMetaData extends V8InnerClass {

  public UUID type;

  public CalculationConfigurationBlock innerType;

}

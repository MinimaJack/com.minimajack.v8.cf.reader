package com.minimajack.v8.metadata.innerclass.configuration.common;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.common.CommonConfigurationBlock;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.UUID;

@V8Class
public class CommonConfiguraionMetaData extends V8InnerClass {

  public UUID type;

  public CommonConfigurationBlock innerType;

}

package com.minimajack.v8.metadata.functionaloption;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;

import java.util.UUID;

@V8Class
public class FunctionalOptionsBlock {

  @V8Version
  public Integer version;
  public MetadataMainInfo v8mn;
  public UUID location;
  public FunctionalOptionContent content;
  @V8Since(version = 2)
  public Boolean privilegedGetMode;
}

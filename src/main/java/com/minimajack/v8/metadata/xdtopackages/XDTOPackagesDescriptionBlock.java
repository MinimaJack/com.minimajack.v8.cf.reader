package com.minimajack.v8.metadata.xdtopackages;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;

@V8Class
public class XDTOPackagesDescriptionBlock {

  @V8Version
  public Integer version;
  public MetadataMainInfo v8mn;
  public String uriNameSpace;
}

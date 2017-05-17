package com.minimajack.v8.metadata.xdtopackages;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;

@V8Class
public class XDTOPackagesDescriptionBlock {

  @V8Version
  public Integer version;
  public V8MetaShortName v8mn;
  public String uriNameSpace;
}

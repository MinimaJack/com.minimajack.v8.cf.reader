package com.minimajack.v8.metadata.httpservice;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;

@V8Class
public class HttpServicesBlock {

  @V8Version
  public Integer version;
  public String rootURL;
  public MetadataMainInfo v8mn;
}

package com.minimajack.v8.metadata.httpservice;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.inner.enums.HttpMethod;

@V8Class
public class MethodDescription {

  public Integer version;
  public String handler;
  public HttpMethod.Values httpMethod;
  public MetadataMainInfo v8mn;
}

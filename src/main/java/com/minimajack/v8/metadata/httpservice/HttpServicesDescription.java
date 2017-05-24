package com.minimajack.v8.metadata.httpservice;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class HttpServicesDescription {

  @V8Version
  public Integer version;
  public HttpServicesBlock info;
  public List<V8InnerClass> sections;
}

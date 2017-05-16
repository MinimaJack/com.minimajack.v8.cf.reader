package com.minimajack.v8.metadata.webservices;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class WebServicesDescription {

  public Integer version;

  public WebServicesDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

package com.minimajack.v8.metadata.inner.classes.webservices;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;
import com.minimajack.v8.metadata.webservices.OperationDescription;

import java.util.List;
import java.util.UUID;

@V8Class
public class WebServiceList extends V8InnerClass {

  public UUID type;

  public List<OperationDescription> descr;
}

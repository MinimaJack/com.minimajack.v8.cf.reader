package com.minimajack.v8.metadata.inner.classes.webservices;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;
import com.minimajack.v8.metadata.webservices.OperationParam;

import java.util.List;
import java.util.UUID;

@V8Class
public class OperationParams extends V8InnerClass {

  public UUID type;
  public List<OperationParam> descr;
}
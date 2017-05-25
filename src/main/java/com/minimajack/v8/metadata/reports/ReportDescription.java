package com.minimajack.v8.metadata.reports;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class ReportDescription {

  public Integer version;
  public ReportDescriptionBlock info;
  public List<V8ClassObject> sections;
}

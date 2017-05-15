package com.minimajack.v8.metadata.documents;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class DocumentDescription {

  public Integer version;
  public DocumentDescriptionBlock dd;
  public List<V8InnerClass> sections;
}

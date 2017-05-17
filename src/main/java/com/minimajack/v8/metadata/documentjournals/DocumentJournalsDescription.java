package com.minimajack.v8.metadata.documentjournals;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class DocumentJournalsDescription {

  public Integer version;
  public DocumentJournalsDescriptionBlock dd;
  public List<V8InnerClass> sections;
}

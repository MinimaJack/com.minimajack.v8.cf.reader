package com.minimajack.v8.metadata.wsreferences;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class WSReferencesDescription {

  public Integer version;

  public WSReferencesDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

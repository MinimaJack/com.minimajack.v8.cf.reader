package com.minimajack.v8.metadata.style;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class StyleDescription {

  public Integer version;

  public StyleDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

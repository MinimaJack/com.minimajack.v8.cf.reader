package com.minimajack.v8.metadata.filtercriteria;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class FilterCriteriaDescription {

  public Integer version;
  public FilterCriteriaBlock fcb;
  public List<V8InnerClass> sections;
}

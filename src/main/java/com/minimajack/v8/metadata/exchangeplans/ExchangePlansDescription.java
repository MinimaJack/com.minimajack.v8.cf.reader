package com.minimajack.v8.metadata.exchangeplans;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class ExchangePlansDescription {

  public Integer version;
  public ExchangePlansBlock epb;
  public List<V8InnerClass> sections;
}

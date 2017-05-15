package com.minimajack.v8.metadata.eventsubscriptions;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class EventSubscriptionsDescription {

  public Integer version;
  public EventSubscriptionsBlock esb;
  public List<V8InnerClass> sections;
}

package com.minimajack.v8.metadata.scheduledjob;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class ScheduledJobDescription {

  public Integer version;

  public ScheduledJobDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

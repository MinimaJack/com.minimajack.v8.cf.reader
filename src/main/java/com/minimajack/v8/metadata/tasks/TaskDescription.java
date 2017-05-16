package com.minimajack.v8.metadata.tasks;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class TaskDescription {

  public Integer version;

  public TaskDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

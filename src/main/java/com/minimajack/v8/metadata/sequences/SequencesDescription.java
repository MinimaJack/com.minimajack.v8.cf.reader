package com.minimajack.v8.metadata.sequences;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class SequencesDescription {

  public Integer version;

  public SequencesDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

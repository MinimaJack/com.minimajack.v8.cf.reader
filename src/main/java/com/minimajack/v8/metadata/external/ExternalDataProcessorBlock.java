package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class ExternalDataProcessorBlock {

  public Integer version;

  public V8MetaDataSimpleDescription sd;

  public List<V8InnerClass> sections;

}

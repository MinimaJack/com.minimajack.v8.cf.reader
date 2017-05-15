package com.minimajack.v8.metadata.dataprocessors;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class DataProcessorDescription {

  public Integer version;
  public DataProcessorBlock info;
  public List<V8InnerClass> sections;
}

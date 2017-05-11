package com.minimajack.v8.metadata.external.forms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8Synonym;

@V8Class
public class FormMetaData {

  public Integer version; // or list of objects

  public FormFullMetaData ffmd;

  public V8Synonym extendedView;
  
}

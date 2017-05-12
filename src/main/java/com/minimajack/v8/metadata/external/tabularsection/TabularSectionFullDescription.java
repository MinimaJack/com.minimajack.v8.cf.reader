package com.minimajack.v8.metadata.external.tabularsection;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;

@V8Class
public class TabularSectionFullDescription {

  public Integer version;

  public TabularSectionDescription tabularSectionDescription;
  
  @Required(required = false)
  public Integer si; // find in catalogs
}

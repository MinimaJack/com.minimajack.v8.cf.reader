package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;

@V8Class
public class PatternDescription {

  public String descr;

  @Required(required = false)
  public Qualifiers[] qualifyies;

}

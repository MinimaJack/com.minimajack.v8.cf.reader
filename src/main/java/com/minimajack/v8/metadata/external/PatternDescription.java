package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8Class
public class PatternDescription extends V8InnerClass {

  public String descr;

  @Required(required = false)
  public Qualifiers[] qualifyies;

}

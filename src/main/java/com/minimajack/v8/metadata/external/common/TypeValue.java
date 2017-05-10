package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.V8Type;

@V8Class
public class TypeValue {

  public V8Type type;

  @Required(required = false)
  public String value;

  @Required(required = false)
  public String value2;

  @Required(required = false)
  public String value3;

}

package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.unknown.UnkUuidInt;

import java.util.List;

@V8Class
public class V8MetaShortName {

  public Integer type;

  public V8InnerInfo sno;

  public String name;

  public V8Synonym synonym;

  public String comment;

  @Required(required = false)
  public Integer und1; // if type == 1 und1 present

  @Required(required = false)
  public List<UnkUuidInt> und2; // if type == 1 und2 present

}

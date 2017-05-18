package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.unknown.UnkUuidInt;

import java.util.List;

@V8Class
public class MetadataMainInfo {

  @V8Version
  public Integer version;

  public V8InnerInfo sno;

  public String name;

  public V8Synonym synonym;

  public String comment;

  @V8Since(version = 1)
  public Integer und1;

  @V8Since(version = 1)
  public List<UnkUuidInt> und2;

}

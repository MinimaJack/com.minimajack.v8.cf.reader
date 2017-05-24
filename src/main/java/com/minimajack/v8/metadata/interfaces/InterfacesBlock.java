package com.minimajack.v8.metadata.interfaces;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;

@V8Class
public class InterfacesBlock {

  @V8Version
  public Integer version;
  public Boolean notSwitchable;
  public MetadataMainInfo v8mn;
  public Integer unk;

}

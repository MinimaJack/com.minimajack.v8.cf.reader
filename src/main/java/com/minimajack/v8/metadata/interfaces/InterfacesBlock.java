package com.minimajack.v8.metadata.interfaces;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;

@V8Class
public class InterfacesBlock {

  @V8Version
  public Integer version;
  public Integer unk1;
  public V8MetaShortName v8mn;
  public Integer unk2;

}

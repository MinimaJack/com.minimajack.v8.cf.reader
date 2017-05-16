package com.minimajack.v8.metadata.functionaloption;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;

import java.util.UUID;

@V8Class
public class FunctionalOptionsBlock {

  @V8Version
  public Integer version;
  public V8MetaShortName v8mn;
  public UUID unk1;
  public FunctionalOptionContentItems unk2;
  @V8Since(version = 2)
  public Integer unk3;
}

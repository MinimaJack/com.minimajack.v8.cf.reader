package com.minimajack.v8.metadata.subsystems;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;

@V8Class
public class SubsystemsObject {

  @V8Version
  public Integer version;
  public Integer unk1;
  public SubsystemsObject2 unk2;
  public String unk3;
  public Integer unk4;
  public Integer unk5;
  public Integer unk6;
  public Integer unk7;
  @V8Since(version = 4)
  public String unk8;
}

package com.minimajack.v8.metadata.commoncommands;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntNotReqUuid;

@V8Class
public class CommonCommandsInfo {

  @V8Version
  public Integer version;
  public Integer unk1;
  public UnkObjectIntNotReqUuid unk2;
  public String unk3;
  public Integer unk4;
  public Integer unk5;
  public Integer unk6;
  public Integer unk7;
  @V8Since(version = 4)
  public String unk8;

}

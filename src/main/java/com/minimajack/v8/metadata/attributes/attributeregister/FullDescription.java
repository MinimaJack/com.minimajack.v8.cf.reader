package com.minimajack.v8.metadata.attributes.attributeregister;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

@V8Class
public class FullDescription {

  @V8Version
  public Integer version;

  public Description descr;

  @V8Since(version = 2)
  public Integer unk;

  @V8Since(version = 2)
  public Integer unk2;

  @V8Since(version = 6)
  public Integer unk3;

  @V8Since(version = 6)
  public Integer unk4;
}

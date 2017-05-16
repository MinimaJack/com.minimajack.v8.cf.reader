package com.minimajack.v8.metadata.attributes.address;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

import java.util.UUID;

@V8Class
public class FullDescription {

  @V8Version
  public Integer version;

  public Description descr;

  public Integer unk22;

  public UUID unk2;

  @V8Since(version = 3)
  public Integer unk3;

}

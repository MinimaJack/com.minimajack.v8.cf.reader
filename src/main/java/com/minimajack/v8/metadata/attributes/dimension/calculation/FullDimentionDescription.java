package com.minimajack.v8.metadata.attributes.dimension.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

import java.util.UUID;

@V8Class
public class FullDimentionDescription {

  @V8Version
  public Integer version;

  public Description descr;

  public UUID unk2;

  public Integer unk3;

  public Integer unk4;
}

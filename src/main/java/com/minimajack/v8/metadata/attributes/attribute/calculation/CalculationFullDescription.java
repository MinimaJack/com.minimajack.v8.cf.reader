package com.minimajack.v8.metadata.attributes.attribute.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

import java.util.UUID;

@V8Class
public class CalculationFullDescription {

  @V8Version
  public Integer version;

  public Description descr;

  @V8Since(version = 5)
  public Integer unk22;
  @V8Since(version = 5)
  public Integer unk23;
  @V8Since(version = 5)
  public UUID unk2;
  @V8Since(version = 5)
  public Integer unk3;
  @V8Since(version = 5)
  public Integer unk4;

}

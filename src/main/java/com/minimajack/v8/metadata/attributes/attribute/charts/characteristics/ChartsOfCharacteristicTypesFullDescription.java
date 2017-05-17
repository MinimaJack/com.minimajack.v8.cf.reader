package com.minimajack.v8.metadata.attributes.attribute.charts.characteristics;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

@V8Class
public class ChartsOfCharacteristicTypesFullDescription {

  @V8Version
  public Integer version;

  public Description descr;

  @V8Since(version = 1)
  public Integer unk;

  @V8Since(version = 1)
  public Integer unk2;

  @V8Since(version = 1)
  public Integer unk3;

}

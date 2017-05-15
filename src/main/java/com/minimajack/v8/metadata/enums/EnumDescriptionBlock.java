package com.minimajack.v8.metadata.enums;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.persist.PersistanceDescriptionInner;
import com.minimajack.v8.metadata.persist.UnkPersistObject;

import java.util.UUID;

@V8Class
public class EnumDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public EnumMetaData v8mn;
  public Integer unk5;
  public UUID unk6;
  public UUID unk7;
  public UUID unk8;
  public UUID unk9;
  public Integer unk10;
  public Integer unk11;
  public UUID unk12;
  public UUID unk13;
  public V8Synonym unk14;
  public V8Synonym unk15;
  public V8Synonym unk16;
  public PersistanceDescriptionInner unk17;
  public UnkPersistObject unk18;
  @V8Since(version = 20)
  public Integer unk19;
}

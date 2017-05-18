package com.minimajack.v8.metadata.constants;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.ChoiceParameterLinks;
import com.minimajack.v8.metadata.external.common.ChoiceParameters;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;

import java.util.UUID;

@V8Class
public class ConstantsMetaData {

  @V8Version
  public Integer version;

  public ConstantsMetaDataInfo cmd;
  public Integer unk1;
  public V8Synonym unk2;
  public V8Synonym unk3;
  public Integer unk4;
  public String unk5;
  public Integer unk6;
  public TypeValue tv;
  public TypeValue tv2;
  public Integer unk7;
  public UUID unk8;
  public Integer unk9;
  public Integer unk10;
  public ChoiceParameterLinks unk11;
  public CompactFlags unk12;
  public ChoiceParameters unk13;
  public Integer unk14;
  public V8Synonym unk15;
  public TypeValue unk16;
  public Integer unk17;
  @V8Since(version = 26)
  public Integer unk18;
  @V8Since(version = 26)
  public Integer unk19;
}

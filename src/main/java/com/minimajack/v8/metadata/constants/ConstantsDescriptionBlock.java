package com.minimajack.v8.metadata.constants;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;

import java.util.UUID;

@V8Class
public class ConstantsDescriptionBlock {

  @V8Version
  public Integer version;
  public ConstantsMetaData metainfo;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public Integer unk5;
  public Integer unk6;
  public V8Synonym unk7;
  public V8Synonym unk8;
  public UUID unk9;
  @V8Since(version = 14)
  public Integer unk10;
}

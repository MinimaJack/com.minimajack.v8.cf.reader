package com.minimajack.v8.metadata.constants;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;

import java.util.UUID;

@V8Class
public class ConstantsDescriptionBlock {

  @V8Version
  public Integer version;
  public Description metainfo;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public DataLockControlMode.Values dataLockControlMode;
  public Boolean useStandardCommands;
  public V8Synonym extendedPresentation;
  public V8Synonym explanation;
  public UUID defaultForm;
  @V8Since(version = 14)
  public Integer unk10;
}

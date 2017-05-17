package com.minimajack.v8.metadata.documentjournals;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;
import com.minimajack.v8.metadata.persist.PersistanceDescriptionInner;

import java.util.UUID;

@V8Class
public class DocumentJournalsDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public DocumentJournalsMetaData dmd;
  public UUID unk3;
  public Integer unk4;
  public UnkObjectListTypes unk5;
  public Integer unk6;
  public UUID unk7;
  public UUID unk8;
  public UUID unk9;
  public UUID unk10;
  public PersistanceDescriptionInner unk11;
  public UUID unk12;
  public V8Synonym unk13;
  public V8Synonym unk14;
  public V8Synonym unk15;
}

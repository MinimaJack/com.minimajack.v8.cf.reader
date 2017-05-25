package com.minimajack.v8.metadata.tasks;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.CompositeIDInfo;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class TaskDescriptionBlock {

  @V8Version
  public Integer version;
  public MetadataMainInfo v8mn;
  public Integer unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public UUID unk5;
  public UUID unk6;
  public UUID unk7;
  public UUID unk8;
  public UUID unk9;
  public UUID unk10;
  public UUID unk11;
  public UUID unk12;
  public UUID unk13;
  public UUID unk14;
  public UUID unk15;
  public UUID unk16;
  public Integer unk17;
  public Integer unk18;
  public Integer unk19;
  public Integer unk20;
  public Integer unk21;
  public Integer unk22;
  public Integer unk23;
  public UUID unk24;
  public UUID unk25;
  public Integer unk26;
  public CompositeIDInfo cid;
  public UUID unk27;
  public MetadataObjectPropertyValueCollection unk28;
  public Integer unk29;
  public Integer unk30;
  public Integer unk31;
  public StandardAttributeDescriptions unk32;
  public UUID unk33;
  public UUID unk34;
  public UUID unk35;
  public V8Synonym unk36;
  public V8Synonym unk37;
  public V8Synonym unk38;
  public V8Synonym unk39;
  public V8Synonym unk40;
  public Integer unk42;
  public CharacteristicsDescriptions unk43;
  @V8Since(version = 29)
  public Integer unk44;
  @V8Since(version = 29)
  public FieldList unk45;
  @V8Since(version = 29)
  public CompactFlags unk46;
  @V8Since(version = 29)
  public Integer unk47;

}

package com.minimajack.v8.metadata.documents;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.persist.CompositeIDInfo;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;

import java.util.UUID;

@V8Class
public class DocumentDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public UUID unk5;
  public UUID unk6;
  public UUID unk7;
  public UUID unk8;
  public DocumentMetaData dmd;
  public UUID unk9;
  public Integer unk10;
  public Integer unk11;
  public Integer unk12;
  public Integer unk13;
  public Integer unk14;
  public UUID unk15;
  public UUID unk16;
  public UUID unk17;
  public Integer unk18;
  public Integer unk19;
  public Integer unk20;
  public MetadataObjectPropertyValueCollection unk21;
  public Integer unk22;
  public MetadataObjectPropertyValueCollection unk23;
  public Integer unk24;
  public UUID unk25;
  public UUID unk26;
  public Integer unk27;
  public CompositeIDInfo unk28;
  public Integer unk29;
  public Integer unk30;
  public StandardAttributeDescriptions unk31;
  public Integer unk32;
  public Integer unk33;
  public UUID unk34;
  public UUID unk35;
  public UUID unk36;
  public V8Synonym unk37;
  public V8Synonym unk38;
  public V8Synonym unk39;
  public V8Synonym unk40;
  public V8Synonym unk41;
  public Integer unk42;
  public Integer unk43;
  @V8Since(version = 34)
  public CharacteristicsDescriptions unk44;
  @V8Since(version = 35)
  public Integer unk45;
  @V8Since(version = 35)
  public FieldList unk46;
  @V8Since(version = 35)
  public CompactFlags unk47;
  @V8Since(version = 35)
  public Integer unk48;

}

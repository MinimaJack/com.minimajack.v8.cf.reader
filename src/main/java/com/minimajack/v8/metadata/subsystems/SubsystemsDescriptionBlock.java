package com.minimajack.v8.metadata.subsystems;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;

@V8Class
public class SubsystemsDescriptionBlock {

  public Integer version;
  public MetadataMainInfo v8mn;
  public Integer unk1;
  public MetadataObjectPropertyValueCollection unk2;
  public Integer unk3;
  public SubsystemsObject so;
  public V8Synonym unk4;
  public MetadataObjectPropertyValueCollection unk5;
}

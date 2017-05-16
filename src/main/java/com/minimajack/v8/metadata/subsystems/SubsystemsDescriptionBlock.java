package com.minimajack.v8.metadata.subsystems;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;

@V8Class
public class SubsystemsDescriptionBlock {

  public Integer version;
  public V8MetaShortName v8mn;
  public Integer unk1;
  public UnkObjectListTypes unk2;
  public Integer unk3;
  public SubsystemsObject so;
  public V8Synonym unk4;
  public UnkObjectListTypes unk5;
}

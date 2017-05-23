package com.minimajack.v8.metadata.commandgroups;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.CommandGroupCategory;
import com.minimajack.v8.metadata.inner.enums.Representation;

@V8Class
public class CommandGroupsBlock {

  public Integer version;
  public CommandGroupInfo gi;
  public CommandGroupCategory.Values category;
  public Representation.Values representation;
  public V8Synonym toolTip;
  public V8Synonym unk4;
  public MetadataMainInfo v8mn;

}

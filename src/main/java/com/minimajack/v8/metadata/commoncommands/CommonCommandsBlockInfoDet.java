package com.minimajack.v8.metadata.commoncommands;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.commandgroups.CommandGroupInfo;
import com.minimajack.v8.metadata.commands.CommandGroup;
import com.minimajack.v8.metadata.commands.Shortcut;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.ParameterUsageMode;
import com.minimajack.v8.metadata.inner.enums.Representation;

@V8Class
public class CommonCommandsBlockInfoDet {

  public Integer version;
  public CommandGroupInfo cgi;
  public Representation.Values representation;
  public V8Synonym tooltip;
  public Integer unk3;
  public Shortcut shortcut;
  public Boolean includeHelpInContents;
  public CommandGroup group;
  public PatternDescription commandParameterType;
  public MetadataMainInfo v8mn;
  public Boolean modifiesData;
  public ParameterUsageMode.Values parameterUsageMode;
}

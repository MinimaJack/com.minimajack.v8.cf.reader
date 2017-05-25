package com.minimajack.v8.metadata.inner.classes.commands;

import com.minimajack.v8.metadata.commands.metadata.CommandDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

public class CommandListMetaDataObject extends V8InnerClass {

  public UUID type;

  public List<CommandDescription> descr;
}

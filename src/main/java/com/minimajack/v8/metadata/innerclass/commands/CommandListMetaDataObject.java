package com.minimajack.v8.metadata.innerclass.commands;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.commands.metadata.CommandDescription;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class CommandListMetaDataObject extends V8InnerClass {

  public UUID type;

  public List<CommandDescription> descr;
}

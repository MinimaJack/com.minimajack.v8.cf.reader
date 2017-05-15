package com.minimajack.v8.metadata.inner.classes.commands;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.commands.CommandDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class CommandList extends V8InnerClass {

  public UUID type;

  public List<CommandDescription> descr;
}

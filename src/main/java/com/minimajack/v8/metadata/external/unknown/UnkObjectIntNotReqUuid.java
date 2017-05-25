package com.minimajack.v8.metadata.external.unknown;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.UUID;

@V8Class
public class UnkObjectIntNotReqUuid extends V8InnerClass {

  public Integer unk2;

  @Required(required = false)
  public UUID unk1;
}

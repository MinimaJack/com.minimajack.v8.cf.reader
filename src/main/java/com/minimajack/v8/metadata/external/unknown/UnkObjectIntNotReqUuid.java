package com.minimajack.v8.metadata.external.unknown;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;

import java.util.UUID;

@V8Class
public class UnkObjectIntNotReqUuid {

  public Integer unk2;

  @Required(required = false)
  public UUID unk1;
}

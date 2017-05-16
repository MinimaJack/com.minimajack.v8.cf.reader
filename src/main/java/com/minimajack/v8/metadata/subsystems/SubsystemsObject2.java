package com.minimajack.v8.metadata.subsystems;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;

import java.util.UUID;

@V8Class
public class SubsystemsObject2 {

  public Integer version;
  @Required(required = false)
  public UUID unk1;
}

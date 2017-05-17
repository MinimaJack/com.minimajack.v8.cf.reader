package com.minimajack.v8.metadata.attributes.resource.accounting;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.attributes.Description;

import java.util.UUID;

@V8Class
public class AccountingFullResourceDescription {

  @V8Version
  public Integer version;

  public Description descr;

  public Integer unk;

  public UUID unk2;
  public UUID unk3;
  public Integer unk4;

}

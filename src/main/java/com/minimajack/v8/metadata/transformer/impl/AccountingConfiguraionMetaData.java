package com.minimajack.v8.metadata.transformer.impl;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.AccountingConfigurationBlock;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;

import java.util.UUID;

@V8Class
public class AccountingConfiguraionMetaData extends MetaDataDescription {

  public UUID type;

  public AccountingConfigurationBlock innerType;

  @Override
  public UUID getType() {
    return this.type;
  }
}

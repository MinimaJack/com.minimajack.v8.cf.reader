package com.minimajack.v8.metadata.innerclass.configuration.accounting;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.accounting.AccountingConfigurationBlock;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.UUID;

@V8Class
public class AccountingConfiguraionMetaData extends V8InnerClass {

  public UUID type;

  public AccountingConfigurationBlock innerType;

}

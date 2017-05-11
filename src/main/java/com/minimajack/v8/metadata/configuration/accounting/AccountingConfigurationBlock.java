package com.minimajack.v8.metadata.configuration.accounting;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;

@V8Class
public class AccountingConfigurationBlock {

  public Integer version;

  public AccountingConfigurationBlockInfo info;

  public List<V8InnerClass> sections;
}

package com.minimajack.v8.metadata.registers.accounting;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class AccountingRegistersDescription {

  public Integer version;
  public AccountingRegistersBlock arb;
  public List<V8ClassObject> sections;

}

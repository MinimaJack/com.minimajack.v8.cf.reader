package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

public class AccountType extends V8InnerClass {

  public Values value;

  public enum Values {
    ACTIVE,
    PASSIVE,
    ACTIVEPASSIVE;
  }
}

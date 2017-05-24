package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "38fc2020-f658-11d5-a3c7-0050bae0a776")
public final class InformationRegisterPeriodicity extends V8InnerClass {

  public enum Values {
    Nonperiodical,
    Year,
    Quarter,
    Month,
    Day,
    Second

  }
}
package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "4f4073cb-6cbe-42f4-aff8-fc179505358b")
public final class BusinessProcessNumberPeriodicity extends V8InnerClass {

  public enum Values {
    Nonperiodical,
    YEAR,
    Quarter,
    Month,
    Day;
  }
}

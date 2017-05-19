package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "a8024559-0f1c-4406-939f-49b3cb749f91")
public final class NumberPeriodicity extends V8InnerClass {

  public enum Values {
    Nonperiodical,
    Year,
    Quarter,
    Month,
    Day;
  }
}

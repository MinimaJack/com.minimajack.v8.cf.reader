package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "a37b703f-9a92-4f6c-9303-7459432d1480")
public final class Periodicity extends V8InnerClass {

  public enum Values {
    YEAR,
    Quarter,
    Month,
    Day;
  }
}

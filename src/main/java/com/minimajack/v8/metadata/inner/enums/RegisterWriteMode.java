package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "6e8e3740-0f2c-11d6-a3c7-0050bae0a776")
public final class RegisterWriteMode extends V8InnerClass {

  public enum Values {
    Independent,
    RecorderSubordinate

  }
}

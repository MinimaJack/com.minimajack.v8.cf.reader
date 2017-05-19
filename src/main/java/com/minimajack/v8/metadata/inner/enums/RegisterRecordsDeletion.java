package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "baa56fa0-1f2a-11d6-a3c7-0050bae0a776")
public final class RegisterRecordsDeletion extends V8InnerClass {

  public enum Values {
    AutoDelete,
    AutoDeleteOff,
    AutoDeleteOnUnpost
  }
}

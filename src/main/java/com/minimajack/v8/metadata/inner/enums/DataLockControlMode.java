package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "b7b7d7f8-11dc-4e0b-9d72-7ec6cc040eef")
public final class DataLockControlMode extends V8InnerClass {

  public enum Values {
    AUTOMATIC,
    MANAGED,
    AUTOMATIC_AND_MANAGED;
  }
}

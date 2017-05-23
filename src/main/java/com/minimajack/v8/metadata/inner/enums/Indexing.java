package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8ClassUUID;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

@V8ClassUUID(uuid = "6b36a200-1957-11d6-a3c7-0050bae0a776")
public final class Indexing extends V8InnerClass {

  public enum Values {
    DontIndex,
    Index,
    IndexWithAdditionalOrder;
  }
}

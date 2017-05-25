package com.minimajack.v8.metadata.inner.enums;

import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

public class RequiredMobileApplicationPermissions extends V8InnerClass {

  public Values value;

  public enum Values {
    MEDIA,
    GEOLOCATION,
    CONTACTS,
    CALENDARS,
    TELEPHONY,
    PUSH_NOTIFICATION,
    LOCAL_NOTIFICATION,
    PRINT,
    BUILD_IN_PURCHASES
  }

}

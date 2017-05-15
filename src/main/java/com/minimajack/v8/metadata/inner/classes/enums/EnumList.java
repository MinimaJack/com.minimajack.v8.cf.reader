package com.minimajack.v8.metadata.inner.classes.enums;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.EnumMetaInfo;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class EnumList extends V8InnerClass {

  public UUID type;

  public List<EnumMetaInfo> emi;
}

package com.minimajack.v8.metadata.external.qualifier.impl;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.inner.enums.V8Type;

import java.util.UUID;

@V8Class
public class DbLinkQuality extends Qualifiers {

  public V8Type type;

  public UUID uuid;
}

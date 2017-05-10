package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.V8Class;

import java.util.List;

@V8Class
public class V8TypeLinkDescription {

  public Integer version;

  public List<V8TypeLink> links;

  public Integer numberElement;
}

package com.minimajack.v8.metadata.style.item;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class StyleItemDescription {

  public Integer version;

  public StyleItemDescriptionBlock info;

  public List<V8ClassObject> sections;
}

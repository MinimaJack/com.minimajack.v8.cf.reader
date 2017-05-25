package com.minimajack.v8.metadata.documentnumerators;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class DocumentNumeratorsDescription {

  public Integer version;

  public DocumentNumeratorsDescriptionBlock info;

  public List<V8ClassObject> sections;
}

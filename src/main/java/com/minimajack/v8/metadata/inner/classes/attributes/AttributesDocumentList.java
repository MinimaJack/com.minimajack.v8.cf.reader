package com.minimajack.v8.metadata.inner.classes.attributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.attributedocument.TypeDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class AttributesDocumentList extends V8InnerClass {

  public UUID type;

  public List<TypeDescription> descr;

}

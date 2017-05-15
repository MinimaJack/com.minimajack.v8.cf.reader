package com.minimajack.v8.metadata.innerclass.attributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.dimension.DimentionDescription;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class DimensionList extends V8InnerClass {

  public UUID type;

  public List<DimentionDescription> descr;

}

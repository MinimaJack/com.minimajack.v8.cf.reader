package com.minimajack.v8.metadata.innerclass.attributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.resource.ResourceDescription;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class ResourceList extends V8InnerClass {

  public UUID type;

  public List<ResourceDescription> descr;

}

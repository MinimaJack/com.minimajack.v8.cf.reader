package com.minimajack.v8.metadata.inner.classes.attributes.information;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.resource.information.ResourceDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class InformationResourceList extends V8InnerClass {

  public UUID type;

  public List<ResourceDescription> descr;

}

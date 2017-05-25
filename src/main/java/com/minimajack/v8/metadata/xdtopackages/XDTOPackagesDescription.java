package com.minimajack.v8.metadata.xdtopackages;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;

import java.util.List;

@V8Class
public class XDTOPackagesDescription {

  public Integer version;

  public XDTOPackagesDescriptionBlock v8mn;

  public List<V8ClassObject> sections;
}

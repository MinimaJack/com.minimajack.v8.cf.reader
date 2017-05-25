package com.minimajack.v8.metadata;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.GuidObject;
import com.minimajack.v8.metadata.inner.classes.V8ClassObject;
import com.minimajack.v8.metadata.version.Version;

import java.util.List;

@V8Class
public class V8MetaData {

  public Integer type;

  public GuidObject currentObject;

  public List<V8ClassObject> mdd;

  @Required(required = false)
  public Version version;

}

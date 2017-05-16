package com.minimajack.v8.metadata.sessionparam;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class SessionParamDescription {

  public Integer version;

  public SessionParamDescriptionBlock v8mn;

  public List<V8InnerClass> sections;
}

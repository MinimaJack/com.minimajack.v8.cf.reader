package com.minimajack.v8.metadata.sessionparam;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;

@V8Class
public class SessionParamDescriptionBlockInfo {

  public Integer version;
  public V8MetaShortName vmn;
  public PatternDescription pd;
}

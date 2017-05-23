package com.minimajack.v8.metadata.external.forms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.type.ListTypes;
import com.minimajack.v8.metadata.inner.enums.FormType;

@V8Class
public class FormFullMetaData {

  public Integer version;

  public MetadataMainInfo v8mn;

  public Integer unk1;

  public FormType.Values formType;

  public ListTypes unk2;
  
}

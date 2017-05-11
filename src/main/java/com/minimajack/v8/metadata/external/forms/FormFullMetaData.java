package com.minimajack.v8.metadata.external.forms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.FormType;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;
import com.minimajack.v8.metadata.external.type.ListTypes;

@V8Class
public class FormFullMetaData {

  public Integer version;

  public V8MetaShortName v8mn;

  public Integer unk1;

  public FormType type;

  public ListTypes unk2;
  
}

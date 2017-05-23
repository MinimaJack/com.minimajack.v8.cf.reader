package com.minimajack.v8.metadata.commonforms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.type.ListTypes;
import com.minimajack.v8.metadata.inner.enums.FormType;

@V8Class
public class CommonFormMetaData {

  @V8Version
  public Integer version;

  public MetadataMainInfo ffmd;

  public Boolean includeHelpInContents;
  public FormType.Values formType;
  @V8Since(version = 10)
  public ListTypes usePurposes;

}

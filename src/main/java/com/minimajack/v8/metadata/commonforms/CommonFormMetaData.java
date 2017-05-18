package com.minimajack.v8.metadata.commonforms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.type.ListTypes;

@V8Class
public class CommonFormMetaData {

  @V8Version
  public Integer version;

  public MetadataMainInfo ffmd;

  public Integer unk1;
  public Integer unk2;
  @V8Since(version = 10)
  public ListTypes unk3;

}

package com.minimajack.v8.metadata.documentnumerators;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CodeType;
import com.minimajack.v8.metadata.inner.enums.DocumentNumberPeriodicity;

@V8Class
public class DocumentNumeratorsDescriptionBlock {

  @V8Version
  public Integer version;
  public MetadataMainInfo v8mn;
  public CodeType.Values codeType;
  public Integer codeLength;
  public DocumentNumberPeriodicity.Values numberPeriodicity;
  public Boolean checkUnique;
  public CodeAllowedLength.Values codeAllowedLength;
}

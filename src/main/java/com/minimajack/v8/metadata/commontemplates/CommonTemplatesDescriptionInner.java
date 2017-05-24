package com.minimajack.v8.metadata.commontemplates;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.inner.enums.TemplateType;

@V8Class
public class CommonTemplatesDescriptionInner {

  public Integer version;
  public MetadataMainInfo md;
  public TemplateType.Values templateType;

}

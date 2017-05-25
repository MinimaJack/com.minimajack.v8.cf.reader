package com.minimajack.v8.metadata.style.item;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.inner.enums.StyleElementType;

@V8Class
public class StyleItemDescriptionBlock {

  public Integer version;
  public StyleElementType.Values type;
  public TypeValue value;
  public MetadataMainInfo v8mn;
}

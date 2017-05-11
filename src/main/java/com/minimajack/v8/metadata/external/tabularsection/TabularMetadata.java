package com.minimajack.v8.metadata.external.tabularsection;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.innerclass.attributes.AttributesSection;

import java.util.List;

@V8Class
public class TabularMetadata {

  public TabularSectionFullDescription tabularSectionFullDescription;

  public List<AttributesSection> attributes;
}

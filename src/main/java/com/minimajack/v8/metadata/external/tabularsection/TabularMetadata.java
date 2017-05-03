package com.minimajack.v8.metadata.external.tabularsection;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.attributes.AttributesSection;

@V8Class
public class TabularMetadata
{
    public TabularSectionFullDescription tabularSectionFullDescription;

    public List<AttributesSection> fields;
}

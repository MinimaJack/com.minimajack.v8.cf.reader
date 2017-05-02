package com.minimajack.v8.metadata.external.tabularsection;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.fields.V8MetaTypesSection;

@V8Class
public class TabularSectionMetadata
{
    public TabularSectionFullDescription tabularSectionFullDescription;

    public List<V8MetaTypesSection> fields;
}

package com.minimajack.v8.metadata.external;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

@V8Class
public class V8MetaDataInnerType
{
    public Integer version;

    public V8MetaDataSimpleDescription sd;

    public List<MetadataSection> sections;

}

package com.minimajack.v8.metadata.configuration;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

@V8Class
public class ExternalDataSourcesConfigurationBlock
{
    public Integer version;

    public ExternalDataSourcesConfigurationBlockInfo info;

    public List<MetadataSection> sections;
}

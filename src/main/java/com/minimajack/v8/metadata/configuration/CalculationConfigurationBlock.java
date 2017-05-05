package com.minimajack.v8.metadata.configuration;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

@V8Class
public class CalculationConfigurationBlock
{
    public Integer version;

    public CalculationConfigurationBlockInfo info;

    public List<MetadataSection> sections;
}

package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;

@V8Class
public class ExternalDataSourcesConfigurationBlock {

  public Integer version;

  public ExternalDataSourcesConfigurationBlockInfo info;

  public List<MetadataSection> sections;
}

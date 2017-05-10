package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;

@V8Class
public class BusinessProcessesConfigurationBlock {

  public Integer version;

  public BusinessProcessesConfigurationBlockInfo info;

  public List<MetadataSection> sections;
}

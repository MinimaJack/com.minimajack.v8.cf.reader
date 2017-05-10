package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;

@V8Class
public class CalculationConfigurationBlock {

  public Integer version;

  public CalculationConfigurationBlockInfo info;

  public List<MetadataSection> sections;
}

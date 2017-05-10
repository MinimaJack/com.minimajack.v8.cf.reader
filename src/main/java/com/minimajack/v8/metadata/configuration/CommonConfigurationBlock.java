package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;

@V8Class
public class CommonConfigurationBlock {

  public Integer version;

  public ConfigurationSimpleDescription sd;

  public List<MetadataSection> sections;
}

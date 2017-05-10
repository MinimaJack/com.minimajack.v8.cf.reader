package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;

@V8Class
public class MainConfigurationBlockInfo {

  public Integer type;

  public MainConfigurationBlockInnerInfo sno;

  public List<MetadataSection> sections;
}

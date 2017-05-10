package com.minimajack.v8.metadata.configuration.sections.externaldatasources;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;
import java.util.UUID;

@V8Class
public class ExternalDataSources extends MetadataSection {

  public UUID type;
  public List<UUID> uuids;
}

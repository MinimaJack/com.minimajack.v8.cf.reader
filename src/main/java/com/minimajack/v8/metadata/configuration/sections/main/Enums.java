package com.minimajack.v8.metadata.configuration.sections.main;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

import java.util.List;
import java.util.UUID;

@V8Class
public class Enums extends MetadataSection {

  public UUID type;

  public List<UUID> uuids;
}

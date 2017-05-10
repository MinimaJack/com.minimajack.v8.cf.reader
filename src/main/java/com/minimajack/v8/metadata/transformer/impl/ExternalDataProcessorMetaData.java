package com.minimajack.v8.metadata.transformer.impl;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.ExternalDataProcessorBlock;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;

import java.util.UUID;

@V8Class
public class ExternalDataProcessorMetaData extends MetaDataDescription {

  public UUID type;

  public ExternalDataProcessorBlock innerType;

  @Override
  public UUID getType() {
    return this.type;
  }
}

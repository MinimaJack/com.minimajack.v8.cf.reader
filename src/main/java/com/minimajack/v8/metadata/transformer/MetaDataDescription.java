package com.minimajack.v8.metadata.transformer;

import com.minimajack.v8.annotation.Transformer;

import java.util.UUID;

@Transformer(transformer = V8MetaDataDescriptionTransformer.class)
public abstract class MetaDataDescription {

  public abstract UUID getType();
}

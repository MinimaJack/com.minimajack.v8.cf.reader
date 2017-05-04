package com.minimajack.v8.metadata.transformer;

import java.util.UUID;

import com.minimajack.v8.annotation.Transformer;

@Transformer(transformer = V8MetaDataDescriptionTransformer.class)
public abstract class MetaDataDescription {
	public abstract UUID getType();
}

package com.minimajack.v8.metadata.transformer.impl;

import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.CommonConfigurationBlock;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;

@V8Class
public class CommonConfiguraionMetaData extends MetaDataDescription {
	public UUID type;

	public CommonConfigurationBlock innerType;

	@Override
	public UUID getType() {
		return type;
	}
}

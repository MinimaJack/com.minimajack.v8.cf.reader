package com.minimajack.v8.metadata.transformer;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.minimajack.v8.metadata.transformer.impl.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.transformer.impl.MainConfiguraionMetaData;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class V8MetaDataDescriptionTransformer extends AbstractTransformer<MetaDataDescription> {

	public static final UUID EXTERNAL_DATA_PROCESSOR = UUID.fromString("c3831ec8-d8d5-4f93-8a22-f9bfae07327f");
	
	public static final UUID MAIN_CONFIGURATION_BLOCK = UUID.fromString("9cd510cd-abfc-11d4-9434-004095e12fc7");

	@Override
	public MetaDataDescription read(ParameterizedType type, ByteBuffer buffer) {
		buffer.mark();
		MetaDataDescription metaInfo = null;
		ClassTransformer.readBracket(buffer);
		UUID guid = V8Reader.read(UUID.class, buffer);
		buffer.reset();
		if (guid.equals(EXTERNAL_DATA_PROCESSOR)) {
			metaInfo = V8Reader.read(ExternalDataProcessorMetaData.class, buffer);
		} else if (guid.equals(MAIN_CONFIGURATION_BLOCK)) {
			metaInfo = V8Reader.read(MainConfiguraionMetaData.class, buffer);
		} else {
			throw new RuntimeException("Unknown section: " + guid);
		}

		return metaInfo;
	}

}

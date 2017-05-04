package com.minimajack.v8.metadata.configuration.sections;

import java.util.List;
import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

@V8Class
public class ScheduledJobs extends MetadataSection {
	public UUID type;
	public List<UUID> uuids;
}

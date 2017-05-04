package com.minimajack.v8.metadata.external.transformer;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.minimajack.v8.metadata.configuration.sections.CommonAttributes;
import com.minimajack.v8.metadata.configuration.sections.CommonModules;
import com.minimajack.v8.metadata.configuration.sections.CommonTemplates;
import com.minimajack.v8.metadata.configuration.sections.FuctionalOptionParams;
import com.minimajack.v8.metadata.configuration.sections.RoleSection;
import com.minimajack.v8.metadata.configuration.sections.ScheduledJobs;
import com.minimajack.v8.metadata.configuration.sections.SessionParams;
import com.minimajack.v8.metadata.external.attributes.AttributesSection;
import com.minimajack.v8.metadata.external.forms.FormsSection;
import com.minimajack.v8.metadata.external.tabularsection.TabularSections;
import com.minimajack.v8.metadata.external.template.TemplateSections;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class SectionTransformer extends AbstractTransformer<MetadataSection> {

	public static final UUID FORMS_SECTION = UUID.fromString("d5b0e5ed-256d-401c-9c36-f630cafd8a62");

	public static final UUID TEMPLATE_SECTION = UUID.fromString("3daea016-69b7-4ed4-9453-127911372fe6");

	public static final UUID FIELD_SECTION = UUID.fromString("ec6bb5e5-b7a8-4d75-bec9-658107a699cf");

	public static final UUID TABULAR_SECTION = UUID.fromString("2bcef0d1-0981-11d6-b9b8-0050bae0a95d");

	public static final UUID ROLE_SECTION = UUID.fromString("09736b02-9cac-4e3f-b4f7-d3e9576ab948");

	public static final UUID COMMON_TEMPLATES_SECTION = UUID.fromString("0c89c792-16c3-11d5-b96b-0050bae0a95d");

	public static final UUID COMMON_MODULES_SECTION = UUID.fromString("0fe48980-252d-11d6-a3c7-0050bae0a776");

	public static final UUID SCHEDULED_JOBS_SECTION = UUID.fromString("11bdaf85-d5ad-4d91-bb24-aa0eee139052");

	public static final UUID COMMON_ATTRIBUTES_SECTION = UUID.fromString("15794563-ccec-41f6-a83c-ec5f7b9a5bc1");

	public static final UUID SESSION_PARAMS_SECTION = UUID.fromString("24c43748-c938-45d0-8d14-01424a72b11e");
	
	public static final UUID FUNCTIONAL_OPTIONS_PARAMS_SECTION = UUID.fromString("30d554db-541e-4f62-8970-a1c6dcfeb2bc");

	@Override
	public MetadataSection read(ParameterizedType type, ByteBuffer buffer) {
		buffer.mark();
		MetadataSection section = null;
		ClassTransformer.readBracket(buffer);
		UUID guid = V8Reader.read(UUID.class, buffer);
		buffer.reset();
		if (guid.equals(FORMS_SECTION)) {
			section = V8Reader.read(FormsSection.class, buffer);
		} else if (guid.equals(TEMPLATE_SECTION)) {
			section = V8Reader.read(TemplateSections.class, buffer);
		} else if (guid.equals(FIELD_SECTION)) {
			section = V8Reader.read(AttributesSection.class, buffer);
		} else if (guid.equals(TABULAR_SECTION)) {
			section = V8Reader.read(TabularSections.class, buffer);
		} else if (guid.equals(ROLE_SECTION)) {
			section = V8Reader.read(RoleSection.class, buffer);
		} else if (guid.equals(COMMON_TEMPLATES_SECTION)) {
			section = V8Reader.read(CommonTemplates.class, buffer);
		} else if (guid.equals(COMMON_MODULES_SECTION)) {
			section = V8Reader.read(CommonModules.class, buffer);
		} else if (guid.equals(SCHEDULED_JOBS_SECTION)) {
			section = V8Reader.read(ScheduledJobs.class, buffer);
		} else if (guid.equals(COMMON_ATTRIBUTES_SECTION)) {
			section = V8Reader.read(CommonAttributes.class, buffer);
		} else if (guid.equals(SESSION_PARAMS_SECTION)) {
			section = V8Reader.read(SessionParams.class, buffer);
		} else if (guid.equals(FUNCTIONAL_OPTIONS_PARAMS_SECTION)) {
			section = V8Reader.read(FuctionalOptionParams.class, buffer);
		} else {
			throw new RuntimeException("Unknown section: " + guid);
		}

		return section;
	}

}

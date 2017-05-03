package com.minimajack.v8.metadata.external.forms;

import java.util.List;
import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;

@V8Class
public class FormsSection
    extends MetadataSection
{
    public UUID type;

    public List<UUID> forms;

}

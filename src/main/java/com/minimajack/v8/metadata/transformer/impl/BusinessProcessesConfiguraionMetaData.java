package com.minimajack.v8.metadata.transformer.impl;

import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.configuration.BusinessProcessesConfigurationBlock;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;

@V8Class
public class BusinessProcessesConfiguraionMetaData
    extends MetaDataDescription
{
    public UUID type;

    public BusinessProcessesConfigurationBlock innerType;

    @Override
    public UUID getType()
    {
        return type;
    }
}

package com.minimajack.v8.metadata;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.GuidObject;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;

@V8Class
public class V8MetaData
{
    public Integer type;

    public GuidObject currentObject;

    public List<MetaDataDescription> mdd;
}

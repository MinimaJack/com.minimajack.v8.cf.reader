package com.minimajack.v8.metadata.external;

import java.util.List;

import com.minimajack.v8.annotation.V8Class;

@V8Class
public class V8MetaData
{
    public Integer type;

    public GuidObject currentObject;

    public List<V8MetaDataDescription> mdd;
}

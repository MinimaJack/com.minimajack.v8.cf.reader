package com.minimajack.v8.metadata.external;

import java.util.UUID;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaFullName;

@V8Class
public class V8MetaDataSimpleDescription
{
    public Integer type;

    public UUID g1;

    public UUID g2;

    public V8MetaFullName name;

    public UUID defaultForm;

    public String unk;

    public UUID auxiliaryForm;

    public void afterUnmarshal()
    {
    }
}

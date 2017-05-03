package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;
import com.minimajack.v8.metadata.external.qualifier.TypeDescription;

@V8Class
public class V8MetaFullNameDescr
{
    public Integer type;

    public V8MetaShortName shortName;

    public TypeDescription typeDescription;
}

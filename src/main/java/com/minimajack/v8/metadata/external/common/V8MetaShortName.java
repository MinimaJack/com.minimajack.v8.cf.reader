package com.minimajack.v8.metadata.external.common;

import java.util.List;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.unknown.UnkUUIDInt;

@V8Class
public class V8MetaShortName
{
    public Integer type;

    public V8InnerInfo sno;

    public String name;

    public V8Synonym synonym;

    public String comment;

    @Required(required = false)
    public Integer und1;

    @Required(required = false)
    public List<UnkUUIDInt> und2;

}

package com.minimajack.v8.metadata.external.qualifier;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;

@V8Class
public class TypeDescription
{
    public String descr;

    @Required(required = false)
    public Qualifiers[] qualifyies;
}

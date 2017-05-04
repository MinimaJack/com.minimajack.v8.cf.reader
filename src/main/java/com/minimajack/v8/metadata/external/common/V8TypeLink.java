package com.minimajack.v8.metadata.external.common;

import java.util.UUID;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;

@V8Class
public class V8TypeLink
{
    public Integer type;

    @Required(required = false)
    public UUID linkedField;
}

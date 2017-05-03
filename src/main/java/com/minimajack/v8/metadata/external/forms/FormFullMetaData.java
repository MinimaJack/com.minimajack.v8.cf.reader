package com.minimajack.v8.metadata.external.forms;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.enums.FormType;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;

@V8Class
public class FormFullMetaData
{
    public Integer version;

    public V8MetaShortName v8mn;

    public Integer unk1;

    public FormType type;

    @Required(required = false)
    public UnknownFormLists unk2;

}

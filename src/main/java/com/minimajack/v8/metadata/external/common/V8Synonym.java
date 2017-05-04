package com.minimajack.v8.metadata.external.common;

import java.util.Map;

import com.minimajack.v8.annotation.V8Class;

@V8Class
public class V8Synonym
{
    public Map<String, String> sinonyms;

    public String getForLanguage( String language )
    {
        return sinonyms.get( language );
    }
    @Override
    public String toString()
    {
        if(sinonyms.isEmpty()){
            return super.toString();
        }
        return "Synonym " + getForLanguage( "ru" );
    }
}

package com.minimajack.v8.metadata.external.transformer;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.minimajack.v8.metadata.external.fields.V8MetaTypesSection;
import com.minimajack.v8.metadata.external.forms.V8MetaFormsSection;
import com.minimajack.v8.metadata.external.tabularsection.V8MetaTabularSection;
import com.minimajack.v8.metadata.external.template.V8MetaTamplateSection;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class SectionTransformer
    extends AbstractTransformer<MetadataSection>
{

    public static final UUID FORMS_SECTION = UUID.fromString( "d5b0e5ed-256d-401c-9c36-f630cafd8a62" );

    public static final UUID TEMPLATE_SECTION = UUID.fromString( "3daea016-69b7-4ed4-9453-127911372fe6" );

    public static final UUID FIELD_SECTION = UUID.fromString( "ec6bb5e5-b7a8-4d75-bec9-658107a699cf" );

    public static final UUID TABULAR_SECTION = UUID.fromString( "2bcef0d1-0981-11d6-b9b8-0050bae0a95d" );

    @Override
    public MetadataSection read( ParameterizedType type, ByteBuffer buffer )
    {
        buffer.mark();
        MetadataSection section = null;
        ClassTransformer.readBracket( buffer );
        UUID guid = V8Reader.read( UUID.class, buffer );
        buffer.reset();
        if ( guid.equals( FORMS_SECTION ) )
        {
            section = V8Reader.read( V8MetaFormsSection.class, buffer );
        }
        else if ( guid.equals( TEMPLATE_SECTION ) )
        {
            section = V8Reader.read( V8MetaTamplateSection.class, buffer );
        }
        else if ( guid.equals( FIELD_SECTION ) )
        {
            section = V8Reader.read( V8MetaTypesSection.class, buffer );
        }
        else if ( guid.equals( TABULAR_SECTION ) )
        {
            section = V8Reader.read( V8MetaTabularSection.class, buffer );
        }
        else
        {
            throw new RuntimeException( "Unknown section: " + guid );
        }

        return section;
    }

}

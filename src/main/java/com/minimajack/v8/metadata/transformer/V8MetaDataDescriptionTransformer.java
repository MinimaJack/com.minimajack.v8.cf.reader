package com.minimajack.v8.metadata.transformer;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.minimajack.v8.metadata.transformer.impl.AccountingConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.BusinessProcessesConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.CalculationConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.transformer.impl.CommonConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.ExternalDataSourcesConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.MainConfiguraionMetaData;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class V8MetaDataDescriptionTransformer
    extends AbstractTransformer<MetaDataDescription>
{

    public static final UUID EXTERNAL_DATA_PROCESSOR = UUID.fromString( "c3831ec8-d8d5-4f93-8a22-f9bfae07327f" );

    public static final UUID COMMON_CONFIGURATION_BLOCK = UUID.fromString( "9cd510cd-abfc-11d4-9434-004095e12fc7" );

    public static final UUID MAIN_CONFIGURATION_BLOCK = UUID.fromString( "9fcd25a0-4822-11d4-9414-008048da11f9" );

    public static final UUID ACCOUNTING_CONFIGURATION_BLOCK = UUID.fromString( "e3687481-0a87-462c-a166-9f34594f9bba" );

    public static final UUID CALCULATION_CONFIGURATION_BLOCK = UUID.fromString( "9de14907-ec23-4a07-96f0-85521cb6b53b" );

    public static final UUID BUSINESS_PROCESSES_CONFIGURATION_BLOCK = UUID
        .fromString( "51f2d5d8-ea4d-4064-8892-82951750031e" );
    
    public static final UUID EXTERNAL_DATA_SOURCES_CONFIGURATION_BLOCK = UUID.fromString( "e68182ea-4237-4383-967f-90c1e3370bc7" );
    @Override
    public MetaDataDescription read( ParameterizedType type, ByteBuffer buffer )
    {
        buffer.mark();
        MetaDataDescription metaInfo = null;
        ClassTransformer.readBracket( buffer );
        UUID guid = V8Reader.read( UUID.class, buffer );
        buffer.reset();
        if ( guid.equals( EXTERNAL_DATA_PROCESSOR ) )
        {
            metaInfo = V8Reader.read( ExternalDataProcessorMetaData.class, buffer );
        }
        else if ( guid.equals( COMMON_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( CommonConfiguraionMetaData.class, buffer );
        }
        else if ( guid.equals( MAIN_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( MainConfiguraionMetaData.class, buffer );
        }
        else if ( guid.equals( ACCOUNTING_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( AccountingConfiguraionMetaData.class, buffer );
        }
        else if ( guid.equals( CALCULATION_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( CalculationConfiguraionMetaData.class, buffer );
        }
        else if ( guid.equals( BUSINESS_PROCESSES_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( BusinessProcessesConfiguraionMetaData.class, buffer );
        }
        else if ( guid.equals( EXTERNAL_DATA_SOURCES_CONFIGURATION_BLOCK ) )
        {
            metaInfo = V8Reader.read( ExternalDataSourcesConfiguraionMetaData.class, buffer );
        }
        else
        {
            throw new RuntimeException( "Unknown section: " + guid );
        }

        return metaInfo;
    }

}

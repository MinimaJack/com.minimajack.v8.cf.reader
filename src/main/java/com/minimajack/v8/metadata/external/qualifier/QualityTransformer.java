package com.minimajack.v8.metadata.external.qualifier;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.qualifier.impl.DBLinkQuality;
import com.minimajack.v8.metadata.external.qualifier.impl.DateQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.NumberQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.StringQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.UndefinedQuality;
import com.minimajack.v8.metadata.external.qualifier.impl.UniqueQuality;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class QualityTransformer
    extends AbstractTransformer<Qualifiers>
{

    @Override
    public Qualifiers read( ParameterizedType type, ByteBuffer buffer )
    {
        buffer.mark();
        Qualifiers readedQuality = null;
        ClassTransformer.readBracket( buffer );
        V8Type enums = V8Reader.read( V8Type.class, buffer );
        buffer.reset();
        switch ( enums )
        {
            case N:
                readedQuality = V8Reader.read( NumberQualifiers.class, buffer );
                break;
            case S:
                readedQuality = V8Reader.read( StringQualifiers.class, buffer );
                break;
            case L:
                readedQuality = V8Reader.read( DBLinkQuality.class, buffer );
                break;
            case D:
                readedQuality = V8Reader.read( DateQualifiers.class, buffer );
                break;
            case B:
                readedQuality = V8Reader.read( UniqueQuality.class, buffer );
                break;
            case U:
                readedQuality = V8Reader.read( UndefinedQuality.class, buffer );
                break;
            default:
                throw new RuntimeException( "Unknown type: " + type );
        }
        return readedQuality;
    }

}

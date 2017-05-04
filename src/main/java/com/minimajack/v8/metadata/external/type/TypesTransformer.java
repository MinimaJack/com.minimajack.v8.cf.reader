package com.minimajack.v8.metadata.external.type;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.type.impl.DBLinkType;
import com.minimajack.v8.metadata.external.type.impl.DateType;
import com.minimajack.v8.metadata.external.type.impl.StringType;
import com.minimajack.v8.metadata.external.type.impl.UndefinedType;
import com.minimajack.v8.metadata.external.type.impl.UniqueType;
import com.minimajack.v8.metadata.external.unknown.UnkObject;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUUID;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUUIDUUID;
import com.minimajack.v8.metadata.external.unknown.UnkObjectUUIDInt;
import com.minimajack.v8.metadata.external.unknown.V8Unknown2;
import com.minimajack.v8.metadata.external.unknown.V8Unknown3;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

public class TypesTransformer
    extends AbstractTransformer<Types>
{
    private static final UUID PREDEFINED_TYPE_1 = UUID.fromString( "98ea8e5a-b586-442b-b944-6e3447734aa7" );

    private static final UUID PREDEFINED_TYPE_2 = UUID.fromString( "9ad557b1-249e-48dc-824b-3e149ecf10a6" );

    private static final UUID PREDEFINED_TYPE_3 = UUID.fromString( "ad3615c5-aae6-4725-89be-91827523abd9" );

    private static final UUID PREDEFINED_TYPE_4 = UUID.fromString( "87024738-fc2a-4436-ada1-df79d395c424" );

    private static final UUID PREDEFINED_TYPE_5 = UUID.fromString( "157fa490-4ce9-11d4-9415-008048da11f9" );

    private static final UUID PREDEFINED_TYPE_6 = UUID.fromString( "ace3fd07-11b2-477e-ab7f-36f0ea37c8dd" );

    private static final UUID PREDEFINED_TYPE_7 = UUID.fromString( "12ca4003-ac70-450e-b897-37faf86bd313" );

    private static final UUID PREDEFINED_TYPE_8 = UUID.fromString( "3b8e6bdd-d648-49d5-af2f-d46d84f87dd5" );

    private static final UUID PREDEFINED_TYPE_9 = UUID.fromString( "b76a58b9-2a56-4e46-bb31-8e04ad9f31ae" );

    private static final UUID PREDEFINED_TYPE_10 = UUID.fromString( "f2eaae14-91a7-47b9-9d69-097877f41580" );

    private static final UUID PREDEFINED_TYPE_11 = UUID.fromString( "5c14e26f-099b-4d37-84a6-b433d87400da" );
    
    @Override
    public Types read( ParameterizedType type, ByteBuffer buffer )
    {
        buffer.mark();
        Types readedType = null;
        ClassTransformer.readBracket( buffer );
        V8Type enums = V8Reader.read( V8Type.class, buffer );
        buffer.reset();
        switch ( enums )
        {
            case S:
                readedType = V8Reader.read( StringType.class, buffer );
                break;
            case L:
                ClassTransformer.readBracket( buffer );
                DBLinkType dbQuality = V8Reader.read( DBLinkType.class, buffer );
                // Each data has additional info
                V8Reader.readChar( buffer, ',' );
                if ( dbQuality.uuid.equals( PREDEFINED_TYPE_1 ) )
                {
                    V8Reader.read( Integer.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_2 ) )
                {
                    V8Reader.read( V8Unknown3.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_3 ) )
                {
                    V8Reader.read( UnkObjectUUIDInt.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_4 ) )
                {
                    V8Reader.read( UnkObject.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_5 ) )
                {
                    V8Reader.read( UnkObjectIntUUID.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_6 ) )
                {
                    V8Reader.read( UnkObjectUUIDInt.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_7 ) )
                {
                    V8Reader.read( Integer.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_8 ) )
                {
                    V8Reader.read( UnkObjectUUIDInt.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_9 ) )
                {
                    V8Reader.read( V8Unknown2.class, buffer );
                }
                else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_10 ) )
                {
                    V8Reader.read( V8Unknown2.class, buffer );
                }else if ( dbQuality.uuid.equals( PREDEFINED_TYPE_11 ) )
                {
                    V8Reader.read( UnkObjectIntUUIDUUID.class, buffer );
                }
                
                ClassTransformer.readCloseBracket( buffer );
                readedType = null;
                break;
            case B:
                readedType = V8Reader.read( UniqueType.class, buffer );
                break;
            case U:
                readedType = V8Reader.read( UndefinedType.class, buffer );
                break;
            case D:
                readedType = V8Reader.read( DateType.class, buffer );
                break;
            default:
                throw new RuntimeException( "Unknown type: " + enums );
        }
        return readedType;
    }

}

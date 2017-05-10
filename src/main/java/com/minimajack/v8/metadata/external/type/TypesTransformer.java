package com.minimajack.v8.metadata.external.type;

import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.type.impl.DateType;
import com.minimajack.v8.metadata.external.type.impl.DbLinkType;
import com.minimajack.v8.metadata.external.type.impl.NumberType;
import com.minimajack.v8.metadata.external.type.impl.StringType;
import com.minimajack.v8.metadata.external.type.impl.UndefinedType;
import com.minimajack.v8.metadata.external.type.impl.UniqueType;
import com.minimajack.v8.metadata.external.unknown.UnkObject;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUuidUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;
import com.minimajack.v8.metadata.external.unknown.UnkObjectUuidInt;
import com.minimajack.v8.metadata.external.unknown.V8Unknown2TypeLink;
import com.minimajack.v8.metadata.external.unknown.V8Unknown3;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

public class TypesTransformer extends AbstractTransformer<Types> {

  private static final UUID PREDEFINED_TYPE_1 = UUID
      .fromString("98ea8e5a-b586-442b-b944-6e3447734aa7");

  private static final UUID PREDEFINED_TYPE_2 = UUID
      .fromString("9ad557b1-249e-48dc-824b-3e149ecf10a6");

  private static final UUID PREDEFINED_TYPE_3 = UUID
      .fromString("ad3615c5-aae6-4725-89be-91827523abd9");

  private static final UUID PREDEFINED_TYPE_4 = UUID
      .fromString("87024738-fc2a-4436-ada1-df79d395c424");

  private static final UUID CONFIGURATION_METADATA = UUID
      .fromString("157fa490-4ce9-11d4-9415-008048da11f9");

  private static final UUID FUNCTIONAL_OPTION_VALUE = UUID
      .fromString("3ea29ea5-66f6-4e3b-8595-d8940db766a2");

  private static final UUID PREDEFINED_TYPE_6 = UUID
      .fromString("ace3fd07-11b2-477e-ab7f-36f0ea37c8dd");

  private static final UUID PREDEFINED_TYPE_7 = UUID
      .fromString("12ca4003-ac70-450e-b897-37faf86bd313");

  private static final UUID PREDEFINED_TYPE_8 = UUID
      .fromString("3b8e6bdd-d648-49d5-af2f-d46d84f87dd5");

  private static final UUID PREDEFINED_TYPE_9 = UUID
      .fromString("b76a58b9-2a56-4e46-bb31-8e04ad9f31ae");

  private static final UUID PREDEFINED_TYPE_10 = UUID
      .fromString("f2eaae14-91a7-47b9-9d69-097877f41580");

  private static final UUID PREDEFINED_TYPE_11 = UUID
      .fromString("5c14e26f-099b-4d37-84a6-b433d87400da");

  private static final UUID PREDEFINED_TYPE_12 = UUID
      .fromString("4500381b-db30-4a10-9db4-990038032acf");

  private static final UUID PREDEFINED_TYPE_13 = UUID
      .fromString("1708fdaa-cbce-4289-b373-07a5a74bee91");

  private static final UUID PREDEFINED_TYPE_14 = UUID
      .fromString("e4c53f94-e5f7-4a34-8c10-218bd811cae1");

  @Override
  public Types read(final ParameterizedType type, final ByteBuffer buffer) {
    buffer.mark();
    Types readedType = null;
    ClassTransformer.readBracket(buffer);
    final V8Type enums = V8Reader.read(V8Type.class, buffer);
    buffer.reset();
    switch (enums) {
      case S: {
        readedType = V8Reader.read(StringType.class, buffer);
        break;
      }
      case L: {
        ClassTransformer.readBracket(buffer);
        final DbLinkType dbType = V8Reader.read(DbLinkType.class, buffer);
        // Each data has additional info
        V8Reader.readChar(buffer, ',');
        if (dbType.uuid.equals(PREDEFINED_TYPE_1)) {
          V8Reader.read(Integer.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_2)) {
          V8Reader.read(V8Unknown3.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_3)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_4)) {
          V8Reader.read(UnkObject.class, buffer);
        } else if (dbType.uuid.equals(CONFIGURATION_METADATA)) {
          V8Reader.read(UnkObjectIntUuid.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_6)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_7)) {
          V8Reader.read(Integer.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_8)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_9)) {
          V8Reader.read(V8Unknown2TypeLink.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_10)) {
          V8Reader.read(V8Unknown2TypeLink.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_11)) {
          V8Reader.read(UnkObjectIntUuidUuid.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_12)) {
          V8Reader.read(ListTypes.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_13)) {
          V8Reader.read(Integer.class, buffer);
        } else if (dbType.uuid.equals(PREDEFINED_TYPE_14)) {
          V8Reader.read(Integer.class, buffer);
        } else if (dbType.uuid.equals(FUNCTIONAL_OPTION_VALUE)) { // TODO: test value
          V8Reader.read(UnkObjectListTypes.class, buffer);
        } else {
          throw new RuntimeException("Undefined uuid: " + dbType.uuid);
        }

        readedType = dbType;
        ClassTransformer.readCloseBracket(buffer);
        break;
      }
      case B: {
        readedType = V8Reader.read(UniqueType.class, buffer);
        break;
      }
      case U: {
        readedType = V8Reader.read(UndefinedType.class, buffer);
        break;
      }
      case D: {
        readedType = V8Reader.read(DateType.class, buffer);
        break;
      }
      case N: {
        readedType = V8Reader.read(NumberType.class, buffer);
        break;
      }
      default:
        throw new RuntimeException("Unknown type: " + enums);
    }
    return readedType;
  }

}

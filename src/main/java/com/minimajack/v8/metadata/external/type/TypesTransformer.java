package com.minimajack.v8.metadata.external.type;

import com.minimajack.v8.metadata.catalog.CharacteristicsDescription;
import com.minimajack.v8.metadata.enums.ApplicationUsePurpose;
import com.minimajack.v8.metadata.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.enums.FillChecking;
import com.minimajack.v8.metadata.enums.RequiredMobileApplicationPermissions;
import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.common.ChoiceParameterLinks;
import com.minimajack.v8.metadata.external.common.ChoiceParameters;
import com.minimajack.v8.metadata.external.common.MetaLink;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.type.impl.DateType;
import com.minimajack.v8.metadata.external.type.impl.InnerClassType;
import com.minimajack.v8.metadata.external.type.impl.NumberType;
import com.minimajack.v8.metadata.external.type.impl.StringType;
import com.minimajack.v8.metadata.external.type.impl.UndefinedType;
import com.minimajack.v8.metadata.external.type.impl.BooleanType;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntNotReqUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectIntUuidUuid;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;
import com.minimajack.v8.metadata.external.unknown.UnkObjectUuidInt;
import com.minimajack.v8.metadata.external.unknown.V8Unknown3;
import com.minimajack.v8.metadata.innerclass.collection.FixedArray;
import com.minimajack.v8.metadata.innerclass.enums.StandartPeriod;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.util.UUID;

public class TypesTransformer extends AbstractTransformer<TypeValue> {

  private static final UUID ENUM_FILL_CHEKING = UUID
      .fromString("98ea8e5a-b586-442b-b944-6e3447734aa7");

  private static final UUID LINK_BY_TYPE = UUID
      .fromString("9ad557b1-249e-48dc-824b-3e149ecf10a6");

  private static final UUID CREATE_ON_INPUT = UUID
      .fromString("ad3615c5-aae6-4725-89be-91827523abd9");

  private static final UUID MULTILANGUAGE_STRING = UUID
      .fromString("87024738-fc2a-4436-ada1-df79d395c424");

  private static final UUID CONFIGURATION_METADATA = UUID
      .fromString("157fa490-4ce9-11d4-9415-008048da11f9");

  private static final UUID FUNCTIONAL_OPTION_VALUE = UUID
      .fromString("3ea29ea5-66f6-4e3b-8595-d8940db766a2");

  private static final UUID ENUM_USE_QUICK_CHOICE = UUID
      .fromString("ace3fd07-11b2-477e-ab7f-36f0ea37c8dd");

  private static final UUID ENUM_CHOICE_HISTORY_ON_INPUT = UUID
      .fromString("12ca4003-ac70-450e-b897-37faf86bd313");

  private static final UUID ENUM_FULL_TEXT_SEARCH = UUID
      .fromString("3b8e6bdd-d648-49d5-af2f-d46d84f87dd5");

  private static final UUID CHOICE_PARAMETER_LINKS = UUID
      .fromString("b76a58b9-2a56-4e46-bb31-8e04ad9f31ae");

  private static final UUID CHOICE_PARAMETERS = UUID
      .fromString("f2eaae14-91a7-47b9-9d69-097877f41580");

  private static final UUID PREDEFINED_TYPE_11 = UUID
      .fromString("5c14e26f-099b-4d37-84a6-b433d87400da");

  private static final UUID FIXED_ARRAY = UUID
      .fromString("4500381b-db30-4a10-9db4-990038032acf");

  private static final UUID ENUM_APPLICATION_USE_PURPOSE = UUID
      .fromString("1708fdaa-cbce-4289-b373-07a5a74bee91");

  private static final UUID ENUM_REQUIRED_MOBILE_APPLICATION_PERMISSIONS = UUID
      .fromString("e4c53f94-e5f7-4a34-8c10-218bd811cae1");

  private static final UUID COMPOSITE_ID = UUID
      .fromString("60ea359f-3a6e-48bb-8e71-d2a457572918");

  private static final UUID CHARACTERISTICS_DESCRIPTION = UUID
      .fromString("fe839d42-d094-40ba-b903-75bccc21ba30");

  private static final UUID STANDART_PERIOD = UUID
      .fromString("2fdc88ec-7c9b-43cd-8ba5-873f043bdd88");

  @Override
  public TypeValue read(final ParameterizedType type, final ByteBuffer buffer) {
    buffer.mark();
    TypeValue readedType = null;
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
        final InnerClassType innerClass = V8Reader.read(InnerClassType.class, buffer);
        // Each data has additional info
        V8Reader.readChar(buffer, ',');
        if (innerClass.uuid.equals(ENUM_FILL_CHEKING)) {
          V8Reader.read(FillChecking.class, buffer);
        } else if (innerClass.uuid.equals(LINK_BY_TYPE)) {
          V8Reader.read(V8Unknown3.class, buffer);
        } else if (innerClass.uuid.equals(CREATE_ON_INPUT)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (innerClass.uuid.equals(MULTILANGUAGE_STRING)) {
          V8Reader.read(V8Synonym.class, buffer);
        } else if (innerClass.uuid.equals(CONFIGURATION_METADATA)) {
          V8Reader.read(MetaLink.class, buffer);
        } else if (innerClass.uuid.equals(ENUM_USE_QUICK_CHOICE)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (innerClass.uuid.equals(ENUM_CHOICE_HISTORY_ON_INPUT)) {
          V8Reader.read(ChoiceHistoryOnInput.class, buffer);
        } else if (innerClass.uuid.equals(ENUM_FULL_TEXT_SEARCH)) {
          V8Reader.read(UnkObjectUuidInt.class, buffer);
        } else if (innerClass.uuid.equals(CHOICE_PARAMETER_LINKS)) {
          V8Reader.read(ChoiceParameterLinks.class, buffer);
        } else if (innerClass.uuid.equals(CHOICE_PARAMETERS)) {
          V8Reader.read(ChoiceParameters.class, buffer);
        } else if (innerClass.uuid.equals(PREDEFINED_TYPE_11)) {
          V8Reader.read(UnkObjectIntUuidUuid.class, buffer);
        } else if (innerClass.uuid.equals(FIXED_ARRAY)) {
          V8Reader.read(FixedArray.class, buffer);
        } else if (innerClass.uuid.equals(ENUM_APPLICATION_USE_PURPOSE)) {
          V8Reader.read(ApplicationUsePurpose.class, buffer);
        } else if (innerClass.uuid.equals(ENUM_REQUIRED_MOBILE_APPLICATION_PERMISSIONS)) {
          V8Reader.read(RequiredMobileApplicationPermissions.class, buffer);
        } else if (innerClass.uuid.equals(FUNCTIONAL_OPTION_VALUE)) { // TODO: test value
          V8Reader.read(UnkObjectListTypes.class, buffer);
        } else if (innerClass.uuid.equals(COMPOSITE_ID)) { // TODO: test value
          V8Reader.read(UnkObjectIntNotReqUuid.class, buffer);
        } else if (innerClass.uuid.equals(CHARACTERISTICS_DESCRIPTION)) { // TODO: test value
          V8Reader.read(CharacteristicsDescription.class, buffer);
        } else if (innerClass.uuid.equals(STANDART_PERIOD)) { // TODO: test value
          V8Reader.read(StandartPeriod.class, buffer);
        } else {
          throw new RuntimeException("Undefined uuid: " + innerClass.uuid);
        }

        readedType = innerClass;
        ClassTransformer.readCloseBracket(buffer);
        break;
      }
      case B: {
        readedType = V8Reader.read(BooleanType.class, buffer);
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

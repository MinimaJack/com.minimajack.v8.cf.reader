package com.minimajack.v8.metadata.external.type;

import com.minimajack.v8.metadata.external.type.impl.BooleanType;
import com.minimajack.v8.metadata.external.type.impl.DateType;
import com.minimajack.v8.metadata.external.type.impl.InnerClassTypeValue;
import com.minimajack.v8.metadata.external.type.impl.NumberType;
import com.minimajack.v8.metadata.external.type.impl.StringType;
import com.minimajack.v8.metadata.external.type.impl.UndefinedType;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;
import com.minimajack.v8.metadata.inner.enums.V8Type;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

public class TypesTransformer extends AbstractTransformer<TypeValue> {

  @Override
  public TypeValue read(final ParameterizedType type, final ByteBuffer buffer) {
    TypeValue readedType = null;
    ClassTransformer.readBracket(buffer);
    final V8Type enums = V8Reader.read(V8Type.class, buffer);
    switch (enums) {
      case S: {
        V8Reader.readChar(buffer, ',');
        readedType = V8Reader.read(StringType.class, buffer);
        break;
      }
      case L: {
        V8Reader.readChar(buffer, ',');
        final InnerClassTypeValue classValue = new InnerClassTypeValue();
        classValue.value = V8Reader.read(V8InnerClass.class, buffer);
        readedType = classValue;
        break;
      }
      case B: {
        V8Reader.readChar(buffer, ',');
        readedType = V8Reader.read(BooleanType.class, buffer);
        break;
      }
      case U: {
        readedType = V8Reader.read(UndefinedType.class, buffer);
        break;
      }
      case D: {
        V8Reader.readChar(buffer, ',');
        readedType = V8Reader.read(DateType.class, buffer);
        break;
      }
      case N: {
        V8Reader.readChar(buffer, ',');
        readedType = V8Reader.read(NumberType.class, buffer);
        break;
      }
      default:
        throw new RuntimeException("Unknown type: " + enums);
    }
    ClassTransformer.readCloseBracket(buffer);
    return readedType;
  }

}

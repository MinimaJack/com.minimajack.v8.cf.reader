package com.minimajack.v8.metadata.external.qualifier;

import com.minimajack.v8.metadata.enums.V8Type;
import com.minimajack.v8.metadata.external.qualifier.impl.DateQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.DbLinkQuality;
import com.minimajack.v8.metadata.external.qualifier.impl.NumberQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.StringQualifiers;
import com.minimajack.v8.metadata.external.qualifier.impl.UndefinedQuality;
import com.minimajack.v8.metadata.external.qualifier.impl.BooleanQuality;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.transformers.impl.ClassTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

public class QualityTransformer extends AbstractTransformer<Qualifiers> {

  @Override
  public Qualifiers read(final ParameterizedType type, final ByteBuffer buffer) {
    buffer.mark();
    Qualifiers readedQuality = null;
    ClassTransformer.readBracket(buffer);
    final V8Type enums = V8Reader.read(V8Type.class, buffer);
    buffer.reset();
    switch (enums) {
      case N: {
        readedQuality = V8Reader.read(NumberQualifiers.class, buffer);
        break;
      }
      case S: {
        readedQuality = V8Reader.read(StringQualifiers.class, buffer);
        break;
      }
      case L: {
        readedQuality = V8Reader.read(DbLinkQuality.class, buffer);
        break;
      }
      case D: {
        readedQuality = V8Reader.read(DateQualifiers.class, buffer);
        break;
      }
      case B: {
        readedQuality = V8Reader.read(BooleanQuality.class, buffer);
        break;
      }
      case U: {
        readedQuality = V8Reader.read(UndefinedQuality.class, buffer);
        break;
      }
      default:
        throw new RuntimeException("Unknown type: " + type);
    }
    return readedQuality;
  }

}

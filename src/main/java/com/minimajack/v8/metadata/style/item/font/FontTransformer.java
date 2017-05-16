package com.minimajack.v8.metadata.style.item.font;

import com.minimajack.v8.metadata.style.item.color.IntObject;
import com.minimajack.v8.metadata.style.item.font.impl.FontDesc;
import com.minimajack.v8.metadata.style.item.font.impl.FontDesc2;
import com.minimajack.v8.transformers.AbstractTransformer;
import com.minimajack.v8.utility.V8Reader;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

public class FontTransformer extends AbstractTransformer<FontDescription> {

  private static final Integer FONT_WEIGHT = 1 << 5;
  private static final Integer FONT_UNK1 = 1 << 4;
  private static final Integer FONT_UNK2 = 1 << 3;
  private static final Integer FONT_UNK3 = 1 << 2;
  private static final Integer FONT_UNK4 = 1 << 1;
  private static final Integer FONT_UNK5 = 1;

  @Override
  public FontDescription read(ParameterizedType type, ByteBuffer buffer) {
    buffer.mark();
    FontDescription innerFont = null;
    final Integer typeFont = V8Reader.read(Integer.class, buffer);
    buffer.reset();
    switch (typeFont) {
      case 0:
        innerFont = V8Reader.read(FontDesc.class, buffer);
      break;
      case 2:
        FontDesc2 readedFont = new FontDesc2();
        readedFont.type = V8Reader.read(Integer.class, buffer);
        V8Reader.readChar(buffer, ',');
        readedFont.flag = V8Reader.read(Integer.class, buffer);
        V8Reader.readChar(buffer, ',');
        readedFont.types = V8Reader.read(IntObject.class, buffer);
        if ((readedFont.flag & FONT_WEIGHT) == FONT_WEIGHT) {
          V8Reader.readChar(buffer, ',');
          readedFont.weight = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont.flag & FONT_UNK1) == FONT_UNK1) {
          V8Reader.readChar(buffer, ',');
          readedFont.unk1 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont.flag & FONT_UNK2) == FONT_UNK2) {
          V8Reader.readChar(buffer, ',');
          readedFont.unk2 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont.flag & FONT_UNK3) == FONT_UNK3) {
          V8Reader.readChar(buffer, ',');
          readedFont.unk3 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont.flag & FONT_UNK4) == FONT_UNK4) {
          V8Reader.readChar(buffer, ',');
          readedFont.unk4 = V8Reader.read(Integer.class, buffer);
        }
        innerFont = readedFont;
      break;
      case 1:
        FontDesc2 readedFont1 = new FontDesc2();
        readedFont1.type = V8Reader.read(Integer.class, buffer);
        V8Reader.readChar(buffer, ',');
        readedFont1.flag = V8Reader.read(Integer.class, buffer);
        V8Reader.readChar(buffer, ',');
        readedFont1.types = V8Reader.read(IntObject.class, buffer);
        if ((readedFont1.flag & FONT_WEIGHT) == FONT_WEIGHT) {
          V8Reader.readChar(buffer, ',');
          readedFont1.weight = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont1.flag & FONT_UNK1) == FONT_UNK1) {
          V8Reader.readChar(buffer, ',');
          readedFont1.unk1 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont1.flag & FONT_UNK2) == FONT_UNK2) {
          V8Reader.readChar(buffer, ',');
          readedFont1.unk2 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont1.flag & FONT_UNK3) == FONT_UNK3) {
          V8Reader.readChar(buffer, ',');
          readedFont1.unk3 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont1.flag & FONT_UNK4) == FONT_UNK4) {
          V8Reader.readChar(buffer, ',');
          readedFont1.unk4 = V8Reader.read(Integer.class, buffer);
        }
        if ((readedFont1.flag & FONT_UNK5) == FONT_UNK5) {
          V8Reader.readChar(buffer, ',');
          readedFont1.unk5 = V8Reader.read(Integer.class, buffer);
        }
        innerFont = readedFont1;
      break;
      default:
        throw new RuntimeException("Unknown font type: " + typeFont);
    }
    return innerFont;
  }

}

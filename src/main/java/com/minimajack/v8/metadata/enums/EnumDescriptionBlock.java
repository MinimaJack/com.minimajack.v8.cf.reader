package com.minimajack.v8.metadata.enums;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;

import java.util.UUID;

@V8Class
public class EnumDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public EnumMetaData v8mn;
  public Boolean useStandardCommands;
  public UUID unk6;
  public UUID unk7;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  @V8Since(version = 17)
  public StandardAttributeDescriptions standardAttributes;
  @V8Since(version = 19)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 20)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;
}

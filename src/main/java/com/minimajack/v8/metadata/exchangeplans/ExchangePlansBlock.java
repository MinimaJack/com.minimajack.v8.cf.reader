package com.minimajack.v8.metadata.exchangeplans;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataExchangeMainPresentation;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.EditType;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class ExchangePlansBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public UUID unk5;
  public UUID unk6;
  public UUID unk7;
  public UUID unk8;
  public UUID unk9;
  public UUID unk10;
  public UUID unk11;
  public MetadataMainInfo v8mn;
  public Boolean useStandardCommands;
  public UUID defaultObjectForm;
  public Integer codeLength;
  public Integer unk15;
  public Integer descriptionLength;
  public Boolean includeHelpInContents;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public EditType.Values editType;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public MetadataObjectPropertyValueCollection basedOn;
  public DataExchangeMainPresentation.Values defaultPresentation;
  public Boolean distributedInfoBase;
  public FieldList inputByString;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public CodeAllowedLength.Values codeAllowedLength;
  @V8Since(version = 27)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 29)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 29)
  public FieldList dataLockFields;
  @V8Since(version = 29)
  public CompactFlags compactFlags;
  @V8Since(version = 29)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

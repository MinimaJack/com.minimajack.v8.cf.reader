package com.minimajack.v8.metadata.chartsofcharacteristictypes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.CharacteristicKindCodesSeries;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.DefaultPresentation;
import com.minimajack.v8.metadata.inner.enums.EditType;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.PredefinedDataUpdate;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class ChartsOfCharacteristicTypesDescriptionBlock {

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
  public UUID unk12;
  public ChartsOfCharacteristicTypesDescriptionBlockInfo coct;
  public Boolean useStandardCommands;
  public MetadataObjectPropertyValueCollection basedOn;
  public Boolean includeHelpInContents;
  public UUID characteristicExtValues;
  public PatternDescription types;
  public Boolean hierarchy;
  public Boolean foldersOnTop;
  public Integer codeLength;
  public Boolean autonumbering;
  public Integer descriptionLength;
  public DefaultPresentation.Values defaultPresentation;
  public EditType.Values editType;
  public UUID defaultObjectForm;
  public UUID defaultFolderForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public UUID defaultFolderChoiceForm;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public FieldList inputByString;
  public Boolean checkUnique;
  public CharacteristicKindCodesSeries.Values codeSeries;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryFolderForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public UUID auxiliaryFolderChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public CodeAllowedLength.Values codeAllowedLength;
  @V8Since(version = 27)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 28)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 28)
  public FieldList dataLockFields;
  @V8Since(version = 28)
  public PredefinedDataUpdate.Values predefinedDataUpdate;
  @V8Since(version = 28)
  public CompactFlags compactFlags;
  @V8Since(version = 28)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

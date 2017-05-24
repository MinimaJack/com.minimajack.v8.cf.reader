package com.minimajack.v8.metadata.businessprocesses;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.BusinessProcessNumberPeriodicity;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CodeType;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.EditType;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
@V8Version
public class BusinessProcessesDescriptionBlock {

  @V8Version
  public Integer version;

  public MetadataMainInfo dmd;
  public Boolean useStandardCommands;
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
  public UUID unk14;
  public MetadataObjectPropertyValueCollection basedOn;
  public CodeType.Values codeType;
  public BusinessProcessNumberPeriodicity.Values numberPeriodicity;
  public Integer codeLength;
  public Boolean checkUnique;
  public Boolean autonumbering;
  public EditType.Values editType;
  public UUID defaultObjectForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public UUID task;
  public Boolean includeHelpInContents;
  public FieldList inputByString;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public Boolean taskCreatingPrivilegedMode;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public CodeAllowedLength.Values codeAllowedLength;
  @V8Since(version = 25)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 26)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 26)
  public FieldList dataLockFields;
  @V8Since(version = 26)
  public CompactFlags compactFlags;
  @V8Since(version = 26)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

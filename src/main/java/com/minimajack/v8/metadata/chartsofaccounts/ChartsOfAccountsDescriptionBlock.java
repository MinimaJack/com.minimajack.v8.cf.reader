package com.minimajack.v8.metadata.chartsofaccounts;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.CharOfAccountCodeSeries;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.DefaultPresentation;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.PredefinedDataUpdate;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class ChartsOfAccountsDescriptionBlock {

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
  public UUID unk13;
  public UUID unk14;
  public ChartsOfAccountsDescriptionBlockInfo coamd;
  public Boolean useStandardCommands;
  public Boolean includeHelpInContents;
  public MetadataObjectPropertyValueCollection basedOn;
  public UUID extDimensionTypes;
  public Integer maxExtDimensionCount;
  public String codeMask;
  public Integer codeLength;
  public Integer descriptionLength;
  public Boolean autoOrderByCode;
  public Integer orderLength;
  public DefaultPresentation.Values defaultPresentation;
  public Integer unk25;
  public UUID defaultObjectForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public FieldList inputByString;
  public Boolean checkUnique;
  public CharOfAccountCodeSeries.Values codeSeries;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions unk36;
  public SomeChartsDimentionObject unk37;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  @V8Since(version = 25)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 26)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 26)
  public FieldList dataLockFields;
  @V8Since(version = 26)
  public PredefinedDataUpdate.Values predefinedDataUpdate;
  @V8Since(version = 26)
  public CompactFlags compactFlags;
  @V8Since(version = 26)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

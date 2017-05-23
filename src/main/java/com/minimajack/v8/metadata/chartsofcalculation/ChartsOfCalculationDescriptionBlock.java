package com.minimajack.v8.metadata.chartsofcalculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.chartsofaccounts.SomeChartsDimentionObject;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.ChartOfCalculationTypesBaseUse;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CodeType;
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
public class ChartsOfCalculationDescriptionBlock {

  @V8Version
  public Integer version;
  public ChartsOfCalculationDescriptionBlockInfo cocmd;
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
  public UUID unk15;
  public UUID unk16;
  public UUID unk17;
  public UUID unk18;
  public UUID unk19;
  public UUID unk20;
  public UUID unk21;
  public UUID unk22;
  public EditType.Values editType;
  public Integer codeLength;
  public CodeType.Values codeType;
  public ChartOfCalculationTypesBaseUse.Values dependenceOnCalculationTypes;
  public MetadataObjectPropertyValueCollection baseCalculationTypes;
  public Boolean actionPeriodUse;
  public Integer descriptionLength;
  public DefaultPresentation.Values defaultPresentation;
  public UUID defaultObjectForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public Boolean useStandardCommands;
  public MetadataObjectPropertyValueCollection basedOn;
  public Boolean includeHelpInContents;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public FieldList inputByString;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public SomeChartsDimentionObject unk43;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public CodeAllowedLength.Values codeAllowedLength;
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 29)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 29)
  public FieldList dataLockFields;
  @V8Since(version = 29)
  public PredefinedDataUpdate.Values predefinedDataUpdate;
  @V8Since(version = 29)
  public CompactFlags compactFlags;
  @V8Since(version = 29)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

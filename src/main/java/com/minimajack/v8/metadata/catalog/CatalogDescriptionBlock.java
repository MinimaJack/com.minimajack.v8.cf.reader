package com.minimajack.v8.metadata.catalog;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.ChoiceMode;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CodeSeries;
import com.minimajack.v8.metadata.inner.enums.CodeType;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.DefaultPresentation;
import com.minimajack.v8.metadata.inner.enums.EditType;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.HierarchyType;
import com.minimajack.v8.metadata.inner.enums.PredefinedDataUpdate;
import com.minimajack.v8.metadata.inner.enums.SubordinationUse;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class CatalogDescriptionBlock {

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
  public CatalogMetaData cmd;
  public Integer levelCount;
  public EditType.Values editType;
  public MetadataObjectPropertyValueCollection owners;
  public Boolean foldersOnTop;
  public Boolean checkUnique;
  public Boolean autonumbering;
  public CodeSeries.Values codeSeries;
  public Integer codeLength;
  public CodeType.Values codeType;
  public Integer descriptionLength;
  public DefaultPresentation.Values defaultPresentation;
  public UUID defaultObjectForm;
  public UUID defaultFolderForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public UUID defaultFolderChoiceForm;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryFolderForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public UUID auxiliaryFolderChoiceForm;
  public Boolean useStandardCommands;
  public MetadataObjectPropertyValueCollection basedOn;
  public Boolean includeHelpInContents;
  public UUID unk31;
  public UUID unk32;
  public HierarchyType.Values hierarchyType;
  public Boolean hierarchy;
  public Boolean limitLevelCount;
  public SubordinationUse.Values subordinationUse;
  public ChoiceMode.Values choiceMode;
  public Boolean quickChoice;
  public FieldList inputByString;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public CodeAllowedLength.Values codeAllowedLength;
  @V8Since(version = 46)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 52)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;
  @V8Since(version = 52)
  public FieldList dataLockFields;
  @V8Since(version = 52)
  public PredefinedDataUpdate.Values predefinedDataUpdate;
  @V8Since(version = 52)
  public CompactFlags compactFlags;
  @V8Since(version = 52)
  public CreateOnInput.Values createOnInput;
}

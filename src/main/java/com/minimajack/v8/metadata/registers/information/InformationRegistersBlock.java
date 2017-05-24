package com.minimajack.v8.metadata.registers.information;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.EditType;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.InformationRegisterPeriodicity;
import com.minimajack.v8.metadata.inner.enums.RegisterWriteMode;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class InformationRegistersBlock {

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
  public InformationRegistersMetaData armd;
  public UUID defaultRecordForm;
  public UUID defaultListForm;
  public InformationRegisterPeriodicity.Values informationRegisterPeriodicity;
  public RegisterWriteMode.Values writeMode;
  public EditType.Values editType;
  public Boolean useStandardCommands;
  public Boolean includeHelpInContents;
  public Boolean mainFilterOnPeriod;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public UUID auxiliaryRecordForm;
  public UUID auxiliaryListForm;
  public V8Synonym recordPresentation;
  public V8Synonym extendedRecordPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  @V8Since(version=28)
  public Boolean enableTotalsSliceLast;
  @V8Since(version=28)
  public Boolean enableTotalsSliceFirst;

}

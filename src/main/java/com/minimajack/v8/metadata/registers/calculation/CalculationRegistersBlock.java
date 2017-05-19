package com.minimajack.v8.metadata.registers.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.Periodicity;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class CalculationRegistersBlock {

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
  public CalculationRegistersMetaData crmd;
  public Periodicity.Values periodicity;
  public Boolean actionPeriod;
  public Boolean basePeriod;
  public UUID schedule;
  public UUID scheduleValue;
  public UUID scheduleDate;
  public UUID chartOfCalculationTypes;
  public UUID defaultListForm;
  public Boolean useStandardCommands;
  public Boolean includeHelpInContents;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public UUID auxiliaryListForm;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;

}

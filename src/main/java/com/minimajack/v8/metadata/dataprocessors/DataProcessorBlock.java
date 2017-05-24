package com.minimajack.v8.metadata.dataprocessors;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8Synonym;

import java.util.UUID;

@V8Class
public class DataProcessorBlock {

  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public DataProcessorMetaData dpmd;
  public UUID defaultForm;
  public Boolean useStandardCommands;
  public Boolean includeHelpInContents;
  public UUID unk6;
  public UUID unk7;
  public UUID auxiliaryForm;
  public V8Synonym extendedPresentation;
  public V8Synonym explanation;
}

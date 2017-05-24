package com.minimajack.v8.metadata.reports;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8Synonym;

import java.util.UUID;

@V8Class
public class ReportDescriptionBlock {

  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public ReportDescriptionMetaData rdmd;
  public UUID defaultForm;
  public UUID mainDataCompositionSchema;
  public UUID defaultSettingsForm;
  public Boolean useStandardCommands;
  public UUID variantsStorage;
  public UUID settingsStorage;
  public UUID defaultVariantForm;
  public Boolean includeHelpInContents;
  public UUID unk11;
  public UUID unk12;
  public UUID auxiliaryForm;
  public V8Synonym extendedPresentation;
  public V8Synonym explanation;
  public UUID auxiliarySettingsForm;
}

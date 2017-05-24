package com.minimajack.v8.metadata.documentjournals;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class DocumentJournalsDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public DocumentJournalsMetaData dmd;
  public UUID defaultForm;
  public Boolean useStandardCommands;
  public MetadataObjectPropertyValueCollection registeredDocuments;
  public Boolean includeHelpInContents;
  public UUID unk7;
  public UUID unk8;
  public UUID unk9;
  public UUID unk10;
  public StandardAttributeDescriptions standardAttributes;
  public UUID auxiliaryForm;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
}

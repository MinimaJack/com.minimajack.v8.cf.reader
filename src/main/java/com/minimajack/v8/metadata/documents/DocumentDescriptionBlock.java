package com.minimajack.v8.metadata.documents;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.external.unknown.MetadataObjectPropertyValueCollection;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.CodeAllowedLength;
import com.minimajack.v8.metadata.inner.enums.CodeType;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.DataLockControlMode;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.DocumentNumberPeriodicity;
import com.minimajack.v8.metadata.inner.enums.Posting;
import com.minimajack.v8.metadata.inner.enums.RealTimePosting;
import com.minimajack.v8.metadata.inner.enums.RegisterRecordsDeletion;
import com.minimajack.v8.metadata.inner.enums.RegisterRecordsWritingOnPost;
import com.minimajack.v8.metadata.inner.enums.SequenceFilling;
import com.minimajack.v8.metadata.persist.CharacteristicsDescriptions;
import com.minimajack.v8.metadata.persist.FieldList;
import com.minimajack.v8.metadata.persist.StandardAttributeDescriptions;

import java.util.UUID;

@V8Class
public class DocumentDescriptionBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID uuidInRegisters;
  public UUID unk4;
  public UUID unk5;
  public UUID unk6;
  public UUID unk7;
  public UUID unk8;
  public DocumentMetaData dmd;
  public UUID numerator;
  public CodeType.Values codeType;
  public Integer codeLength;
  public DocumentNumberPeriodicity.Values numberPeriodicity;
  public Boolean checkUnique;
  public Boolean autonumbering;
  public UUID defaultObjectForm;
  public UUID defaultListForm;
  public UUID defaultChoiceForm;
  public Posting.Values posting;
  public RegisterRecordsDeletion.Values registerRecordsDeletion;
  public RealTimePosting.Values realTimePosting;
  public MetadataObjectPropertyValueCollection basedOn;
  public Boolean useStandardCommands;
  public MetadataObjectPropertyValueCollection registerRecords;
  public Boolean includeHelpInContents;
  public UUID unk25;
  public UUID unk26;
  public SequenceFilling.Values sequenceFilling;
  public FieldList inputByString;
  public DataLockControlMode.Values dataLockControlMode;
  public FullTextSearch.Values fullTextSearch;
  public StandardAttributeDescriptions standardAttributes;
  public Boolean privilegedPostingMode;
  public Boolean privilegedUnpostingMode;
  public UUID auxiliaryObjectForm;
  public UUID auxiliaryListForm;
  public UUID auxiliaryChoiceForm;
  public V8Synonym objectPresentation;
  public V8Synonym extendedObjectPresentation;
  public V8Synonym listPresentation;
  public V8Synonym extendedListPresentation;
  public V8Synonym explanation;
  public RegisterRecordsWritingOnPost.Values registerRecordsWritingOnPost;
  public CodeAllowedLength.Values codeAllowedLength;
  @V8Since(version = 34)
  public CharacteristicsDescriptions characteristics;
  @V8Since(version = 35)
  public CreateOnInput.Values createOnInput;
  @V8Since(version = 35)
  public FieldList dataLockFields;
  @V8Since(version = 35)
  public CompactFlags compactFlags;
  @V8Since(version = 35)
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

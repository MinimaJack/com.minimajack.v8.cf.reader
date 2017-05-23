package com.minimajack.v8.metadata.commonattributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.ChoiceParameterLinks;
import com.minimajack.v8.metadata.external.common.ChoiceParameters;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.type.TypeValue;
import com.minimajack.v8.metadata.external.unknown.CompactFlags;
import com.minimajack.v8.metadata.inner.enums.ChoiceHistoryOnInput;
import com.minimajack.v8.metadata.inner.enums.CreateOnInput;
import com.minimajack.v8.metadata.inner.enums.FillChecking;
import com.minimajack.v8.metadata.inner.enums.FoldersAndItemsUse;
import com.minimajack.v8.metadata.inner.enums.UseQuickChoice;

import java.util.UUID;

@V8Class
public class CommonAttributesBlockInfo {

  public Integer version;
  public CommonAttributesBlockInfoDet v8mn;
  public Boolean passwordMode;
  public V8Synonym format;
  public V8Synonym tooltip;
  public Boolean markNegatives;
  public String mask;
  public Boolean multiLine;
  public TypeValue minValue;
  public TypeValue maxValue;
  public FoldersAndItemsUse foldersAndItemsUse;
  public UUID choiceForm;
  public UseQuickChoice.Values quickChoice;
  public FillChecking.Values fillChecking;
  public ChoiceParameterLinks choiceParameterLinks;
  public CompactFlags compactFlags;
  public ChoiceParameters choiceParameters;
  public Boolean extendedEdit;
  public V8Synonym editFormat;
  public TypeValue fillingValue;
  public Boolean fillFromFillingValue;
  public CreateOnInput.Values createOnInput;
  public ChoiceHistoryOnInput.Values choiceHistoryOnInput;

}

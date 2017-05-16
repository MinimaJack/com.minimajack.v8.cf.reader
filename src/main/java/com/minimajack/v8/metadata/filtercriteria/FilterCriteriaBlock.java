package com.minimajack.v8.metadata.filtercriteria;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;

import java.util.UUID;

@V8Class
public class FilterCriteriaBlock {

  @V8Version
  public Integer version;
  public UUID unk1;
  public UUID unk2;
  public UUID unk3;
  public UUID unk4;
  public FilterCriteriaDesciptionBlock fcdb;
  public UnkObjectListTypes unk5;
  public Integer unk6;
  public UUID unk7;
  public UUID unk8;
  public V8Synonym unk33;
  public V8Synonym unk34;
  public V8Synonym unk35;

}

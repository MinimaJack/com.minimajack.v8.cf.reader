package com.minimajack.v8.metadata.commonattributes;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.MetaDataObjectLink;
import com.minimajack.v8.metadata.inner.enums.CommonAttributeAuthenticationSeparation;
import com.minimajack.v8.metadata.inner.enums.CommonAttributeAutoUse;
import com.minimajack.v8.metadata.inner.enums.CommonAttributeSeparatedDataUse;
import com.minimajack.v8.metadata.inner.enums.CommonAttributeUsersSeparation;
import com.minimajack.v8.metadata.inner.enums.FullTextSearch;
import com.minimajack.v8.metadata.inner.enums.Indexing;

@V8Class
public class CommonAttributesBlock {

  @V8Version
  public Integer version;
  public CommonAttributesBlockInfo info;
  public CommonAttributeContent content;
  public Indexing.Values indexing;
  public FullTextSearch.Values fullTextSearch;
  public Integer unk3;
  public CommonAttributeAutoUse.Values autoUse;
  public MetaDataObjectLink dataSeparationValue;
  public MetaDataObjectLink dataSeparationUse;
  public MetaDataObjectLink conditionalSeparation;
  public CommonAttributeUsersSeparation.Values usersSeparation;
  public CommonAttributeAuthenticationSeparation.Values authenticationSeparation;
  public CommonAttributeSeparatedDataUse.Values separatedDataUse;
  @V8Since(version=4)
  public Integer unk11;
}

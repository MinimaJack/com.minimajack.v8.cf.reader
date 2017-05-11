package com.minimajack.v8.metadata.external;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaFullName;

import java.util.UUID;

@V8Class
public class V8MetaDataSimpleDescription {

  public Integer version;

  public UUID objectUuid;

  public UUID g2;

  public V8MetaFullName name;

  public UUID defaultForm;

  public String unk;

  public UUID auxiliaryForm;

}

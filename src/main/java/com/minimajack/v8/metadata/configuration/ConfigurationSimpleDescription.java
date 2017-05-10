package com.minimajack.v8.metadata.configuration;

import com.minimajack.v8.annotation.Required;
import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.V8MetaFullName;
import com.minimajack.v8.metadata.external.common.V8Synonym;
import com.minimajack.v8.metadata.external.type.ListArrayTypes;
import com.minimajack.v8.metadata.external.type.ListTypes;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;
import com.minimajack.v8.metadata.external.unknown.V8Unknown2;

import java.util.UUID;

@V8Class
public class ConfigurationSimpleDescription {

  public Integer type;

  public V8MetaFullName name;

  public String unk1;

  public Integer unk2;

  public V8Synonym detailedInfo;

  public V8Synonym shortInfo;

  public V8Synonym copyrights;

  public V8Synonym addressSeller;

  public V8Synonym addressInfo;

  public UUID unk8;

  public UUID unk9;

  public UUID unk10;

  public UUID unk11;

  public Integer unk12;

  public String seller;

  public String version;

  public String addressUdates;

  public Integer unk16;

  public V8Unknown2 unk17;

  public Integer unk18;

  public V8Unknown2 unk19;

  public Integer configurationType;

  public UUID unk21;

  public UUID unk22;

  public UUID unk23;

  public UUID unk24;

  public Integer unk25;

  public V8Unknown2 unk26;

  public Integer unk27;

  public Integer unk28;

  public UUID unk29;

  public UUID unk30;

  public UUID unk31;

  @Required(required = false)
  public ListTypes unk32;

  @Required(required = false)
  public UUID unk33;

  @Required(required = false)
  public UUID unk34;

  @Required(required = false)
  public Integer unk35;

  @Required(required = false)
  public UUID unk36;

  @Required(required = false)
  public Integer unk37;

  @Required(required = false)
  public UnkObjectListTypes unk38;

  @Required(required = false)
  public ListArrayTypes unk39;

  @Required(required = false)
  public Integer unk40;

  @Required(required = false)
  public String unk41;

  @Required(required = false)
  public Integer unk42;

  public void afterUnmarshal() {}
}

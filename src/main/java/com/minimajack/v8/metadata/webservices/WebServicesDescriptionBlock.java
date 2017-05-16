package com.minimajack.v8.metadata.webservices;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;
import com.minimajack.v8.metadata.external.unknown.UnkObjectListTypes;

@V8Class
public class WebServicesDescriptionBlock {

  @V8Version
  public Integer version;
  public String url;
  public V8MetaShortName v8mn;
  public UnkObjectListTypes unk1;
  public String endPoint;
  public WebServiceImportedPackets unk2;
  @V8Since(version = 4)
  public Integer unk3;
  @V8Since(version = 4)
  public Integer unk4;
}

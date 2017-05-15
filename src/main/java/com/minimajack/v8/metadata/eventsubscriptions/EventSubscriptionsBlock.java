package com.minimajack.v8.metadata.eventsubscriptions;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.V8MetaShortName;
import java.util.UUID;

@V8Class
public class EventSubscriptionsBlock {
  public Integer version;
  public V8MetaShortName v8mn;
  public PatternDescription pd;
  public String unk1;
  public UUID unk2;
  public String unk3;
}

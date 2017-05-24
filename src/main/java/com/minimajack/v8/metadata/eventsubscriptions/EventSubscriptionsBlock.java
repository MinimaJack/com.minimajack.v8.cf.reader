package com.minimajack.v8.metadata.eventsubscriptions;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.PatternDescription;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;
import java.util.UUID;

@V8Class
public class EventSubscriptionsBlock {
  public Integer version;
  public MetadataMainInfo v8mn;
  public PatternDescription source;
  public String event;
  public UUID handlerModule;
  public String handlerFunction;
}

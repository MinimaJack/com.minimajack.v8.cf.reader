package com.minimajack.v8.metadata.scheduledjob;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.common.MetadataMainInfo;

import java.util.UUID;

@V8Class
public class ScheduledJobDescriptionBlock {

  public Integer version;
  public MetadataMainInfo vmn;
  public String key;
  public String description;
  public Boolean use;
  public Boolean predefined;
  public UUID handlerModule;
  public String handlerFunction;
  public Integer restartCountOnFailure;
  public Integer restartIntervalOnFailure;
}

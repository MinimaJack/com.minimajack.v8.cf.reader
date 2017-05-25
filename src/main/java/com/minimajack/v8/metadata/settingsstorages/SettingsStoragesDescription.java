package com.minimajack.v8.metadata.settingsstorages;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class SettingsStoragesDescription {

  public Integer version;

  public SettingsStoragesDescriptionBlock info;

  public List<V8InnerClass> sections;
}

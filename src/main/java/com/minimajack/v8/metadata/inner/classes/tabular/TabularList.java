package com.minimajack.v8.metadata.inner.classes.tabular;

import com.minimajack.v8.metadata.external.tabularsection.TabularMetadata;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

public class TabularList extends V8InnerClass {

  public UUID type;

  public List<TabularMetadata> tabularSections;

}

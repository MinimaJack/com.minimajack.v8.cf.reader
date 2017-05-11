package com.minimajack.v8.metadata.innerclass.tabular;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.tabularsection.TabularMetadata;
import com.minimajack.v8.metadata.innerclass.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class TabularSections extends V8InnerClass {

  public UUID type;

  public List<TabularMetadata> tabularSections;

}

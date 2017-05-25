package com.minimajack.v8.metadata.inner.classes.documentjournal;

import com.minimajack.v8.metadata.documentjournals.column.ColumnsTypeDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

public class ColumnList extends V8InnerClass {

  public UUID type;

  public List<ColumnsTypeDescription> descr;

}

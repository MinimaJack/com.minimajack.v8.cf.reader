package com.minimajack.v8.metadata.inner.classes.attributes.charts.accounting.extdimention;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.flags.AccountingFlagDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class ExtDimensionAccountingFlags extends V8InnerClass {

  public UUID type;

  public List<AccountingFlagDescription> descr;

}

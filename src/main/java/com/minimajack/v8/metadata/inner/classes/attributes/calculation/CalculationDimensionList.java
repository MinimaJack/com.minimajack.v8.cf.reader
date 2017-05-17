package com.minimajack.v8.metadata.inner.classes.attributes.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.dimension.calculation.DimentionDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class CalculationDimensionList extends V8InnerClass {

  public UUID type;

  public List<DimentionDescription> descr;

}

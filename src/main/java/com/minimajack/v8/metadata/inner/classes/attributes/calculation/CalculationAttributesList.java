package com.minimajack.v8.metadata.inner.classes.attributes.calculation;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.attributes.attribute.calculation.CalculationTypeDescription;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;
import java.util.UUID;

@V8Class
public class CalculationAttributesList extends V8InnerClass {

  public UUID type;

  public List<CalculationTypeDescription> descr;

}

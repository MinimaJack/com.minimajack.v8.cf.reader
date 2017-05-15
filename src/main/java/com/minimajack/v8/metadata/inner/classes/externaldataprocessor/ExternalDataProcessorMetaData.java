package com.minimajack.v8.metadata.inner.classes.externaldataprocessor;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.external.ExternalDataProcessorBlock;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.UUID;

@V8Class
public class ExternalDataProcessorMetaData extends V8InnerClass {

  public UUID type;

  public ExternalDataProcessorBlock innerType;

}

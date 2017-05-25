package com.minimajack.v8.metadata.inner.classes;

import com.minimajack.v8.annotation.Transformer;
import com.minimajack.v8.metadata.inner.classes.transformer.InnerClassTransformer;

import java.util.UUID;

@Transformer(transformer = InnerClassTransformer.class)
public abstract class V8InnerClass {

  public UUID classUUID;
}

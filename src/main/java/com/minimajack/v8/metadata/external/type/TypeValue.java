package com.minimajack.v8.metadata.external.type;

import com.minimajack.v8.annotation.Transformer;

@Transformer(transformer = TypesTransformer.class)
public abstract class TypeValue {

  public abstract Object getValue();
}

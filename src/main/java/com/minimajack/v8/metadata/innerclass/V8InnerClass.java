package com.minimajack.v8.metadata.innerclass;

import com.minimajack.v8.annotation.Transformer;
import com.minimajack.v8.metadata.innerclass.transformer.InnerClassTransformer;

@Transformer(transformer = InnerClassTransformer.class)
public abstract class V8InnerClass {

}

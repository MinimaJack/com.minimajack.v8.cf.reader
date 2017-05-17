package com.minimajack.v8.metadata.commonpictures;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.classes.V8InnerClass;

import java.util.List;

@V8Class
public class CommonPicturesDescription {

  public Integer version;

  public CommonPicturesDescriptionInner formInnerDescription;

  public List<V8InnerClass> sections;

}

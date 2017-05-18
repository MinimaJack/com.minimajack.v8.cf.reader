package com.minimajack.v8.metadata.persist;

import com.minimajack.v8.annotation.V8Class;

import java.util.List;

@V8Class
public class StandardAttributeDescriptions {

  public List<StandardAttributeDescription> items;

  public int count() {
    return items.size();
  }
}

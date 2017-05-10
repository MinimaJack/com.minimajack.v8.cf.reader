package com.minimajack.v8.metadata.external.common;

import com.minimajack.v8.annotation.V8Class;

import java.util.Map;

@V8Class
public class V8Synonym {

  public Map<String, String> sinonyms;

  public String getForLanguage(final String language) {
    return this.sinonyms.get(language);
  }

  @Override
  public String toString() {
    if (this.sinonyms.isEmpty()) {
      return super.toString();
    }
    return "Synonym " + getForLanguage("ru");
  }
}

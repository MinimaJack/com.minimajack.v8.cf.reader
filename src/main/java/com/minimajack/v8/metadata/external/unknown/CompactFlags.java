package com.minimajack.v8.metadata.external.unknown;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.metadata.inner.enums.ChoiceDataGetModeOnInputByString;
import com.minimajack.v8.metadata.inner.enums.FullTextSearchOnInputByString;
import com.minimajack.v8.metadata.inner.enums.SearchStringModeOnInputByString;

@V8Class
public class CompactFlags {

  public SearchStringModeOnInputByString.Values searchStringModeOnInputByString;

  public FullTextSearchOnInputByString.Values fullTextSearchOnInputByString;

  public ChoiceDataGetModeOnInputByString.Values choiceDataGetModeOnInputByString;
}

package com.minimajack.v8.metadata.commonforms;

import com.minimajack.v8.annotation.V8Class;
import com.minimajack.v8.annotation.V8Since;
import com.minimajack.v8.annotation.V8Version;
import com.minimajack.v8.metadata.external.common.V8Synonym;

@V8Class
public class CommonFormDescriptionInner {
	@V8Version
	public Integer version;
	public CommonFormMetaData md;
	public V8Synonym extendedPresentation;
	@V8Since(version=2)
	public V8Synonym explanation;
	@V8Since(version=2)
	public Boolean useStandardCommands;
}

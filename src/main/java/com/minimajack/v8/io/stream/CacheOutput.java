package com.minimajack.v8.io.stream;

import java.io.OutputStream;

public abstract class CacheOutput extends OutputStream 
{
    public abstract boolean isInCache();
}

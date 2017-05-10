package com.minimajack.v8.io.factory;

import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.stream.SmartV8OutputStream;

import java.io.IOException;

public interface StreamFactory {

  SmartV8OutputStream createStream(V8File file) throws IOException;
}

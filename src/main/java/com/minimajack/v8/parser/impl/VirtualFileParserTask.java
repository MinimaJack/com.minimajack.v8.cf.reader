package com.minimajack.v8.parser.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.StreamFactory;
import com.minimajack.v8.io.factory.impl.FileStreamFactory;
import com.minimajack.v8.io.stream.SmartV8OutputStream;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.parser.result.Result;
import com.minimajack.v8.parser.result.ResultType;

@SuppressWarnings("serial")
public class VirtualFileParserTask
    extends ParserTask
{
    final Logger logger = LoggerFactory.getLogger( VirtualFileParserTask.class );

    private StreamFactory streamFactory = new FileStreamFactory();

    private V8File file;

    public VirtualFileParserTask( V8File file )
    {
        this.file = file;
    }

    @Override
    protected Result compute()
    {
        Result result;
        Path path = null;
        try (SmartV8OutputStream fos = streamFactory.createStream( file );
            InputStream dataStream = file.getBody().getDataStream();)
        {
            path = fos.getPath();
            ByteStreams.copy( dataStream, fos );
            result = new Result( fos.getPath(), ResultType.FILE );
        }
        catch ( IOException e )
        {
            logger.error( "Error in FileReader", e );
            result = new Result( path, ResultType.ERROR );

        }
        return result;

    }

}

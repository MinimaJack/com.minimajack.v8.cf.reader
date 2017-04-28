package com.minimajack.v8.parser.impl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.CachedStreamFactory;
import com.minimajack.v8.io.factory.impl.FileCachedStreamFactory;
import com.minimajack.v8.io.stream.CacheOutput;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.parser.result.Result;
import com.minimajack.v8.parser.result.ResultType;

@SuppressWarnings("serial")
public class VirtualCachedFileParserTask
    extends ParserTask
{
    final Logger logger = LoggerFactory.getLogger( VirtualCachedFileParserTask.class );

    private CachedStreamFactory streamFactory = new FileCachedStreamFactory();

    private V8File file;

    public VirtualCachedFileParserTask( V8File file )
    {
        this.file = file;
    }

    @Override
    protected Result compute()
    {
        Result result = new Result();

        try (CacheOutput fos = streamFactory.createStream( file ))
        {

            if ( fos.isInCache() )
            {
                result = new Result( fos.getPath(), ResultType.FILE );
            }
            else
            {

                try (InputStream dataStream = file.getBody().getDataStream();)
                {
                    ByteStreams.copy( dataStream, fos );
                    result = new Result( fos.getPath(), ResultType.FILE );
                }
                catch ( Exception e )
                {
                    logger.error( "Error while saving data to disk", e );
                    return new Result( fos.getPath(), ResultType.ERROR );
                }

            }
        }
        catch ( IOException e )
        {
            logger.error( "Error while creating stream", e );
        }

        return result;
    }
}

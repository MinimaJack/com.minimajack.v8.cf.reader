package com.minimajack.v8.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.CachedStreamFactory;
import com.minimajack.v8.io.factory.impl.FileCachedStreamFactory;
import com.minimajack.v8.io.stream.CacheOutput;

@SuppressWarnings("serial")
public class VirtualCachedFileReader
    extends RecursiveTask<Boolean>
{
    final Logger logger = LoggerFactory.getLogger( VirtualCachedFileReader.class );

    private CachedStreamFactory streamFactory = new FileCachedStreamFactory();

    private V8File file;

    public VirtualCachedFileReader( V8File file )
    {
        this.file = file;
    }

    @Override
    protected Boolean compute()
    {
        Boolean allOk = true;

        try (CacheOutput fos = streamFactory.createStream( file ))
        {

            if ( fos.isInCache() )
            {
                return allOk;
            }

            try (InputStream dataStream = file.getBody().getDataStream();)
            {
                ByteStreams.copy( dataStream, fos );
            }
            catch ( Exception e )
            {
                logger.error( "Error while saving data to disk", e );
                allOk = false;
            }
        }
        catch ( IOException e )
        {
            logger.error( "Error in FileReader", e );
            allOk = false;
        }

        return allOk;
    }

}

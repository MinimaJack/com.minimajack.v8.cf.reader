package com.minimajack.v8.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.factory.StreamFactory;
import com.minimajack.v8.io.factory.impl.FileStreamFactory;

@SuppressWarnings("serial")
public class VirtualFileReader
    extends RecursiveTask<Boolean>
{
    final Logger logger = LoggerFactory.getLogger( VirtualFileReader.class );

    private StreamFactory streamFactory = new FileStreamFactory();

    private V8File file;

    public VirtualFileReader( V8File file )
    {
        this.file = file;
    }

    @Override
    protected Boolean compute()
    {
        Boolean allOk = true;

        try (OutputStream fos = streamFactory.createStream( file );
            InputStream dataStream = file.getBody().getDataStream();)
        {
            ByteStreams.copy( dataStream, fos );
        }
        catch ( IOException e )
        {
            logger.error( "Error in FileReader", e );
            allOk = false;
        }

        return allOk;
    }

}

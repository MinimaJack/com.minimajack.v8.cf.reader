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
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.ProjectTree;

public class VirtualCachedFileParserTask
    extends ParserTask
{
    /**
     * 
     */
    private static final long serialVersionUID = 6050931028538206418L;

    final transient Logger logger = LoggerFactory.getLogger( VirtualCachedFileParserTask.class );

    private transient CachedStreamFactory streamFactory = new FileCachedStreamFactory();

    private transient V8File file;

    public VirtualCachedFileParserTask( V8File file )
    {
        this.file = file;
    }

    @Override
    protected ProjectTree compute()
    {
        ProjectTree result = null;

        try (CacheOutput fos = streamFactory.createStream( file ))
        {
            if ( fos.isInCache() )
            {
                result = new ProjectTree( fos.getPath(), FileType.FILE );
            }
            else
            {

                try (InputStream dataStream = file.getBody().getDataStream();)
                {
                    ByteStreams.copy( dataStream, fos );
                    result = new ProjectTree( fos.getPath(), FileType.FILE );
                }
                catch ( Exception e )
                {
                    logger.error( "Error while saving data to disk", e );
                    return new ProjectTree( fos.getPath(), FileType.ERROR );
                }

            }
            result.setName( file.getAttributes().getName() );
        }
        catch ( IOException e )
        {
            logger.error( "Error while creating stream", e );
        }

        return result;
    }
}

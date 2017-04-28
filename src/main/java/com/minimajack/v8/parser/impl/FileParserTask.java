package com.minimajack.v8.parser.impl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.model.Context;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.parser.result.ResultList;

@SuppressWarnings("serial")
public class FileParserTask
    extends ParserTask
{
    final Logger logger = LoggerFactory.getLogger( FileParserTask.class );

    public Container container;

    private String filePath;

    private String destPath;

    private Strategy strategy;

    public FileParserTask( String filePath, String destPath, Strategy strategy )
    {
        this.filePath = filePath;
        this.destPath = destPath;
        this.strategy = strategy;
    }

    @Override
    public ResultList compute()
    {
        ResultList resultList = new ResultList();
        try (RandomAccessFile aFile = new RandomAccessFile( filePath, "r" ); FileChannel inChannel = aFile.getChannel();)
        {
            MappedByteBuffer buffer = inChannel.map( FileChannel.MapMode.READ_ONLY, 0, inChannel.size() );
            buffer.order( ByteOrder.LITTLE_ENDIAN );

            Context root = new Context();
            root.setName( destPath );
            if ( !filePath.endsWith( ".hbk" ) )
            {
                root.setInflated( true );
            }
            root.setReader( ContainerParserTask.class );

            this.container = new Container( buffer );
            this.container.setContext( root );
            ContainerParserTask reader = new ContainerParserTask();
            reader.setContext( root );
            reader.setContainer( this.container );
            reader.setStrategy( strategy );
            resultList.merge( ForkJoinPool.commonPool().invoke( reader ) );

        }
        catch ( IOException e )
        {
            logger.error( "Error while parse root container: {}", e.getMessage() );
        }
        catch ( OutOfMemoryError e )
        {
            logger.error( "Out of memory, can't map file to memory", e );
        }
        return resultList;
    }
}

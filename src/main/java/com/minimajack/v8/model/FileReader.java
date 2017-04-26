package com.minimajack.v8.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.model.Context;

@SuppressWarnings("serial")
public class FileReader
    extends RecursiveTask<Boolean>
{
    final Logger logger = LoggerFactory.getLogger( FileReader.class );

    public Container container;

    private String filePath;

    private String destPath;

    private Strategy strategy;

    public FileReader( String filePath, String destPath, Strategy strategy )
    {
        this.filePath = filePath;
        this.destPath = destPath;
        this.strategy = strategy;
    }

    @Override
    public Boolean compute()
    {
        boolean allOk = true;
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
            root.setReader( ContainerReader.class );

            this.container = new Container( buffer );
            this.container.setContext( root );
            ContainerReader reader = new ContainerReader();
            reader.setContext( root );
            reader.setContainer( this.container );
            reader.setStrategy( strategy );
            reader.read();

        }
        catch ( IOException e )
        {
            allOk = false;
            logger.error( "Error while parse root container: {}", e.getMessage() );
        }
        catch ( OutOfMemoryError e )
        {
            allOk = false;
            logger.error( "Out of memory, can't map file to memory", e );
        }
        return allOk;
    }
}

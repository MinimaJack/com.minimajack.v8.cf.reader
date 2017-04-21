package com.minimajack.v8.parser;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.model.ContainerReader;
import com.minimajack.v8.model.Context;

public class Reader
{
    final Logger logger = LoggerFactory.getLogger( Reader.class );
    public Container container;

    public final void unpack( String string, String destination )
    {
        try (RandomAccessFile aFile = new RandomAccessFile( string, "r" ); FileChannel inChannel = aFile.getChannel();)
        {
            MappedByteBuffer buffer = inChannel.map( FileChannel.MapMode.READ_ONLY, 0, inChannel.size() );
            buffer.order( ByteOrder.LITTLE_ENDIAN );

			Context root = new Context();
			root.setName(destination);
			if (!string.endsWith(".hbk")) {
				root.setInflated(true);
			}
			root.setReader(ContainerReader.class);

			this.container = new Container(buffer);
			this.container.setContext(root);

			root.parseContainer(container);

        }
        catch ( IOException e )
        {
            logger.error( "Error while parse root container: {}", e.getMessage() );
        }
        catch( OutOfMemoryError e){
            logger.error( "Out of memory, can't map file to memory", e );
        }
    }
}

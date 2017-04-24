package com.minimajack.v8.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.model.FileReader;
import com.minimajack.v8.model.SimpleFileContainerWriter;

public class MainApp
{
    final Logger logger = LoggerFactory.getLogger( MainApp.class );

    public static void main( String[] args )
        throws InterruptedException, ExecutionException
    {
        Logger logger = LoggerFactory.getLogger( MainApp.class );

        if ( args.length != 2 )
        {
            logger.info( "Usage %file% %path%" );
            return;
        }
        long times = System.currentTimeMillis();
        File fileInput = new File( args[0] );
        File fileOutput = new File( args[1] );
        if ( !fileInput.exists() )
        {
            logger.error( "File not exsist" );
            throw new RuntimeException();
        }
        if ( fileInput.isFile() )
        {
            FileReader reader = new FileReader( args[0], args[1] );
            reader.compute();
        }
        else
        {
            SimpleFileContainerWriter fscw = new SimpleFileContainerWriter( fileInput, true );
            fscw.writeAllData();
            byte[] data = fscw.getRawData();
            try (FileOutputStream fos = new FileOutputStream( fileOutput ))
            {
                ByteStreams.copy( new ByteArrayInputStream( data ), fos );
            }
            catch ( Exception e )
            {
            }
        }

        logger.info( "Time: {}", (int) ( System.currentTimeMillis() - times ) / 1000 );
    }

}

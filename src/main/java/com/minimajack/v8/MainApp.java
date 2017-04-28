package com.minimajack.v8;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.packer.SimpleFileContainerWriter;
import com.minimajack.v8.project.Project;

public class MainApp
{
    final Logger logger = LoggerFactory.getLogger( MainApp.class );

    public static void main( String[] args )
        throws InterruptedException, ExecutionException
    {
        Logger logger = LoggerFactory.getLogger( MainApp.class );

        Strategy defaultStrategy = Strategy.MODIFYDATE;

        if ( args.length < 2 || args.length > 3 )
        {
            logger.info( "Usage %file% %path%" );
            return;
        }
        if ( args.length == 3 )
        {
            defaultStrategy = Strategy.valueOf( args[2] );
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
            Project project = new Project();
            project.setPackedFile( fileInput );
            project.setLocation( fileOutput );
            project.setStrategy( defaultStrategy );
            try
            {
                project.unpackProject();
            }
            catch ( JAXBException e )
            {
                e.printStackTrace();
            }
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

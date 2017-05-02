package com.minimajack.v8;

import java.io.File;
import java.util.concurrent.ExecutionException;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.project.Project;

public class MainApp
{
    final Logger logger = LoggerFactory.getLogger( MainApp.class );

    public static void main( String[] args )
        throws InterruptedException, ExecutionException, JAXBException
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
            project.unpackProject();
        }
        else
        {
            Project project = new Project();
            project.setPackedFile( fileOutput );
            project.setLocation( fileInput );
            project.packProject();
        }

        logger.info( "Time: {}", (int) ( System.currentTimeMillis() - times ) / 1000 );
    }

}

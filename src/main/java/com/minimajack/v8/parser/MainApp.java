package com.minimajack.v8.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.model.SimpleFileContainerWriter;

public class MainApp
{

    public static void main( String[] args )
    {
        if ( args.length != 2 )
        {
            System.out.println( "Usage %file% %path%" );
            return;
        }
        long times = System.currentTimeMillis();
        File fileInput = new File( args[0] );
        File fileOutput = new File( args[1] );
        if ( !fileInput.exists() )
        {
            throw new RuntimeException( "File not exsist" );
        }
        if ( fileInput.isFile() )
        {
            Reader reader = new Reader();
            reader.unpack( args[0], args[1] );
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

        System.out.println( "Time: " + (int) ( System.currentTimeMillis() - times ) / 1000 );
    }

}

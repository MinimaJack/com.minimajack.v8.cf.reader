package com.minimajack.v8.project;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.parser.impl.FileParserTask;
import com.minimajack.v8.parser.result.Result;

public class Project
{
    final Logger logger = LoggerFactory.getLogger( Project.class );

    public static final String BASE_NAME = "project.xml";

    public static final String BASE_SRC_NAME = "src";

    private File packedFile;

    private File location;

    private Strategy strategy;

    public void loadProject()
    {
    }

    public void saveProject()
    {

    }

    public boolean unpackProject()
        throws JAXBException
    {
        FileParserTask reader = new FileParserTask( packedFile.getPath(), location.getPath() + File.separator
            + BASE_SRC_NAME + File.separator, strategy );
        Result result = reader.compute();
        String projectFile = location.getPath() + File.separator + BASE_NAME;
        logger.debug( "Project path {}", projectFile );

        result.relativize( location.toPath().toAbsolutePath() );

        JAXBContext jaxbContext = JAXBContext.newInstance( Result.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

        jaxbMarshaller.marshal( result, new File( projectFile ) );
        return true;
    }

    public File getPackedFile()
    {
        return packedFile;
    }

    public void setPackedFile( File packedFile )
    {
        this.packedFile = packedFile;
    }

    public File getLocation()
    {
        return location;
    }

    public void setLocation( File location )
    {
        this.location = location;
    }

    public Strategy getStrategy()
    {
        return strategy;
    }

    public void setStrategy( Strategy strategy )
    {
        this.strategy = strategy;
    }
}

package com.minimajack.v8.project;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.parser.impl.FileParserTask;
import com.minimajack.v8.parser.result.Result;

public class Project
{
    public static final String BASE_DIR = "src" + File.separator;

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
        FileParserTask reader = new FileParserTask( packedFile.getPath(), location.getPath() + File.separator + "src"
            + File.separator, strategy );
        Result result = reader.compute();
        String projectFile = location.getPath() + File.separator + "project.xml";
        result.relativize( location.toPath().toAbsolutePath() );
        System.out.println( projectFile );
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

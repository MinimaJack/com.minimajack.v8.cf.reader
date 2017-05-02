package com.minimajack.v8.project;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.packer.ProjectWriter;
import com.minimajack.v8.parser.impl.FileParserTask;

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

    public boolean packProject()
        throws JAXBException
    {

        JAXBContext jaxbContext = JAXBContext.newInstance( ProjectTree.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File file = new File( getProjectPath() );
        ProjectTree tree = (ProjectTree) jaxbUnmarshaller.unmarshal( file );

        ProjectWriter fscw = new ProjectWriter( tree, true, location.getPath() + File.separator);
        fscw.writeAllData();
        byte[] data = fscw.getRawData();
        try (FileOutputStream fos = new FileOutputStream( packedFile ))
        {
            ByteStreams.copy( new ByteArrayInputStream( data ), fos );
        }
        catch ( Exception e )
        {
        }
        return true;
    }

    public String getProjectPath()
    {
        return location.getPath() + File.separator + BASE_NAME;
    }

    public boolean unpackProject()
        throws JAXBException
    {
        FileParserTask reader = new FileParserTask( packedFile.getPath(), location.getPath() + File.separator
            + BASE_SRC_NAME + File.separator, strategy );
        ProjectTree result = reader.compute();
        String projectFile = location.getPath() + File.separator + BASE_NAME;
        logger.debug( "Project path {}", projectFile );

        result.relativize( location.toPath().toAbsolutePath() );

        JAXBContext jaxbContext = JAXBContext.newInstance( ProjectTree.class );
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

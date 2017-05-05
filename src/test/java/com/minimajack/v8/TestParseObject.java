package com.minimajack.v8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.metadata.V8MetaData;
import com.minimajack.v8.metadata.external.forms.FormDescription;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.external.qualifier.QualityTransformer;
import com.minimajack.v8.metadata.external.tabularsection.strange.StrangeObject;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;
import com.minimajack.v8.metadata.external.transformer.SectionTransformer;
import com.minimajack.v8.metadata.external.type.Types;
import com.minimajack.v8.metadata.external.type.TypesTransformer;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;
import com.minimajack.v8.metadata.transformer.V8MetaDataDescriptionTransformer;
import com.minimajack.v8.project.Project;
import com.minimajack.v8.utility.V8Reader;

public class TestParseObject
{

    @BeforeClass
    public static void initReader()
    {
        new V8Reader();
        V8Reader.init();
        V8Reader.registerTransformer(MetadataSection.class, new SectionTransformer());
        V8Reader.registerTransformer(MetaDataDescription.class, new V8MetaDataDescriptionTransformer());
        V8Reader.registerTransformer(Qualifiers.class, new QualityTransformer());
        V8Reader.registerTransformer(Types.class, new TypesTransformer());
    }

    @Test
    public void testStange()
        throws InstantiationException, IllegalAccessException, IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( classLoader.getResource( "strangeTabularObject" ).getFile() );
        try (FileInputStream fis = new FileInputStream( file ))
        {
            byte[] data = ByteStreams.toByteArray( new FileInputStream( file ) );
            StrangeObject strangeInfo = V8Reader.read( StrangeObject.class, ByteBuffer.wrap( data ) );
            assertNotNull( strangeInfo );
        }
        catch ( Exception e )
        {
        }

    }

    @Test
    public void testMetadata()
        throws InstantiationException, IllegalAccessException, IOException
    {
        File f = new File( "./unpacked/testsupp_out/АвтоОбменДанными.epf/src/741c5561-f70b-40de-b523-d13804fcab6a" );
        byte[] data = new byte[(int) f.length()];
        ByteStreams.readFully( new FileInputStream( f ), data );
        ByteBuffer b = ByteBuffer.wrap( data );
        b.get();
        b.get();
        b.get();
        V8MetaData version = V8Reader.read( V8MetaData.class, b );
        assertNotNull( version );
    }

    @Test
    public void testFormMetadata()
        throws InstantiationException, IllegalAccessException, IOException
    {
        File f = new File( "./unpacked/tests_out/ИнтеграцияС1СДокументооборот.epf/src/Forms/БизнесПроцессИсполнение/metadata.mdo" );
        byte[] data = new byte[(int) f.length()];
        ByteStreams.readFully( new FileInputStream( f ), data );
        ByteBuffer b = ByteBuffer.wrap( data );
        b.get();
        b.get();
        b.get();
        FormDescription version = V8Reader.read( FormDescription.class, b );
        assertNotNull( version );
    }

    @Test
    public void testAll()
        throws InstantiationException, IllegalAccessException, IOException, JAXBException
    {
        for ( File file : new File( "./unpacked/testsupp/" ).listFiles() )
        {
            Project project = new Project();
            project.setPackedFile( file );
            project.setLocation( new File( "./unpacked/testsupp_out/" + file.getName() + "/" ) );
            project.setStrategy( Strategy.MODIFYDATE );
            try
            {
                project.unpackProject();
            }
            catch ( Exception e )
            {
                throw new RuntimeException( "ERROR WHILE UNPACK PROJECT" + file.getName() );
            }

        }

    }
    @Test
    public void testAllErp()
        throws InstantiationException, IllegalAccessException, IOException, JAXBException
    {
        for ( File file : new File( "./unpacked/tests/" ).listFiles() )
        {
            Project project = new Project();
            project.setPackedFile( file );
            project.setLocation( new File( "./unpacked/tests_out/" + file.getName() + "/" ) );
            project.setStrategy( Strategy.MODIFYDATE );
            try
            {
                project.unpackProject();
            }
            catch ( Exception e )
            {
                throw new RuntimeException( "ERROR WHILE UNPACK PROJECT" + file.getName() );
            }

        }

    }
}

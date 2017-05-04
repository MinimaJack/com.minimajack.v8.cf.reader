package com.minimajack.v8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.external.qualifier.QualityTransformer;
import com.minimajack.v8.metadata.external.tabularsection.strange.StrangeObject;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;
import com.minimajack.v8.metadata.external.transformer.SectionTransformer;
import com.minimajack.v8.metadata.external.type.Types;
import com.minimajack.v8.metadata.external.type.TypesTransformer;
import com.minimajack.v8.utility.V8Reader;

public class TestParseObject
{

    @BeforeClass
    public static void initReader()
    {
        new V8Reader();
        V8Reader.init();
        V8Reader.registerTransformer( MetadataSection.class, new SectionTransformer() );
        V8Reader.registerTransformer( Qualifiers.class, new QualityTransformer() );
        V8Reader.registerTransformer( Types.class, new TypesTransformer() );
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

}

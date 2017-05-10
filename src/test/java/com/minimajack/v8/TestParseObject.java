package com.minimajack.v8;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;

import javax.xml.bind.JAXBException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.io.Strategy;
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

public class TestParseObject {

  @BeforeClass
  public static void initReader() {
    new V8Reader();
    V8Reader.init();
    V8Reader.registerTransformer(MetadataSection.class, new SectionTransformer());
    V8Reader
        .registerTransformer(MetaDataDescription.class, new V8MetaDataDescriptionTransformer());
    V8Reader.registerTransformer(Qualifiers.class, new QualityTransformer());
    V8Reader.registerTransformer(Types.class, new TypesTransformer());
  }

  @Test
  public void testStange() throws InstantiationException, IllegalAccessException, IOException {
    final ClassLoader classLoader = getClass().getClassLoader();
    final File file = new File(classLoader.getResource("strangeTabularObject").getFile());
    try (FileInputStream fis = new FileInputStream(file)) {
      final byte[] data = ByteStreams.toByteArray(fis);
      final StrangeObject strangeInfo =
          V8Reader.read(StrangeObject.class, ByteBuffer.wrap(data));
      assertNotNull(strangeInfo);
    } catch (final Exception e) {}

  }

  @Test
  public void testSimpleConfiguration() throws JAXBException, InterruptedException, ExecutionException {
    Project project = new Project();
    project.setPackedFile(new File("./src/test/resources/cf.cf"));
    project.setLocation(new File("./unpacked/cf.cf/"));
    project.setStrategy(Strategy.MODIFYDATE);
    project.setForceRecompile(true);
    try {
      project.unpackProject();
    } catch (Exception e) {
      throw new RuntimeException("ERROR WHILE UNPACK PROJECT");
    }
  }

  @Test
  public void testAll() throws InstantiationException, IllegalAccessException, IOException,
      JAXBException {
    for (File file : new File("./unpacked/testsupp/").listFiles()) {
      Project project = new Project();
      project.setPackedFile(file);
      project.setLocation(new File("./unpacked/testsupp_out/" + file.getName() + "/"));
      project.setStrategy(Strategy.MODIFYDATE);
      try {
        project.unpackProject();
      } catch (Exception e) {
        throw new RuntimeException("ERROR WHILE UNPACK PROJECT" + file.getName());
      }

    }

  }

  @Test
  public void testAllErp() throws InstantiationException, IllegalAccessException, IOException,
      JAXBException {
    for (File file : new File("./unpacked/tests/").listFiles()) {
      Project project = new Project();
      project.setPackedFile(file);
      project.setLocation(new File("./unpacked/tests_out/" + file.getName() + "/"));
      project.setStrategy(Strategy.MODIFYDATE);
      try {
        project.unpackProject();
      } catch (Exception e) {
        throw new RuntimeException("ERROR WHILE UNPACK PROJECT" + file.getName());
      }

    }

  }

}

package com.minimajack.v8.project;

import com.google.common.io.ByteStreams;

import com.minimajack.v8.code.impl.CodeProcessor;
import com.minimajack.v8.code.impl.MetadataProcessor;
import com.minimajack.v8.code.impl.RelativizeProcessor;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.packer.ProjectWriter;
import com.minimajack.v8.parser.impl.FileParserTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Project {

  final Logger logger = LoggerFactory.getLogger(Project.class);

  public static final String BASE_NAME = "project.xml";

  public static final String SRC_PATH = "src";

  private File packedFile;

  private File location;

  private Strategy strategy;

  public boolean packProject() throws JAXBException {

    final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectTree.class);
    final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    final File file = new File(getProjectPath());
    final ProjectTree tree = (ProjectTree) jaxbUnmarshaller.unmarshal(file);

    final ProjectWriter fscw =
        new ProjectWriter(tree, true, this.location.getPath() + File.separator);
    fscw.writeAllData();
    final byte[] data = fscw.getRawData();
    try (FileOutputStream fos = new FileOutputStream(this.packedFile)) {
      ByteStreams.copy(new ByteArrayInputStream(data), fos);
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public String getProjectPath() {
    return this.location.getPath() + File.separator + BASE_NAME;
  }

  public boolean unpackProject() throws JAXBException {
    final FileParserTask reader =
        new FileParserTask(this.packedFile.getPath(), this.location.getPath()
            + File.separator
            + SRC_PATH
            + File.separator, this.strategy);
    final ProjectTree result = reader.compute();
    final String projectFile = this.location.getPath() + File.separator + BASE_NAME;
    this.logger.debug("Project path {}", projectFile);

    final CodeProcessor codeProcessor = new CodeProcessor();
    codeProcessor.addProcessor(new RelativizeProcessor(this.location.toPath().toAbsolutePath()));
    if (this.packedFile.getName().endsWith(".epf")) {
      codeProcessor.addProcessor(new MetadataProcessor(this.location.toPath().toAbsolutePath()));
    }
    codeProcessor.process(result);

    final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectTree.class);
    final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    jaxbMarshaller.marshal(result, new File(projectFile));
    return true;
  }

  public File getPackedFile() {
    return this.packedFile;
  }

  public void setPackedFile(final File packedFile) {
    this.packedFile = packedFile;
  }

  public File getLocation() {
    return this.location;
  }

  public void setLocation(final File location) {
    this.location = location;
  }

  public Strategy getStrategy() {
    return this.strategy;
  }

  public void setStrategy(final Strategy strategy) {
    this.strategy = strategy;
  }
}

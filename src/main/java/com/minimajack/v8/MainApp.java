package com.minimajack.v8;

import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.project.Project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBException;

public class MainApp {

  public static final int STRATEGY_PARAM = 3;

  public static void main(final String[] args) throws InterruptedException, ExecutionException,
      JAXBException {
    final Logger logger = LoggerFactory.getLogger(MainApp.class);

    Strategy defaultStrategy = Strategy.MODIFYDATE;

    if (args.length < 2 || args.length > STRATEGY_PARAM) {
      logger.info("Usage %file% %path%");
      return;
    }
    if (args.length == STRATEGY_PARAM) {
      defaultStrategy = Strategy.valueOf(args[2]);
    }

    final long times = System.currentTimeMillis();
    final File fileInput = new File(args[0]);
    final File fileOutput = new File(args[1]);
    if (!fileInput.exists()) {
      logger.error("File not exsist");
      throw new RuntimeException();
    }
    if (fileInput.isFile()) {
      final Project project = new Project();
      project.setPackedFile(fileInput);
      project.setLocation(fileOutput);
      project.setStrategy(defaultStrategy);
      project.unpackProject();
    } else {
      final Project project = new Project();
      project.setPackedFile(fileOutput);
      project.setLocation(fileInput);
      project.packProject();
    }
    logger.info("Time: {}", TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - times)));
  }

}

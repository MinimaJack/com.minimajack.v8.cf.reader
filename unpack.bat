@echo OFF
Echo Start parsing
@java -Xms1G -Xmx3G -jar com.minimajack.v8.cf.reader-0.0.2-SNAPSHOT-jar-with-dependencies.jar %1 %2

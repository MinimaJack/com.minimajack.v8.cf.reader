package com.minimajack.v8.code.impl;

import com.minimajack.v8.code.ProjectTreeSearcher;
import com.minimajack.v8.metadata.V8MetaData;
import com.minimajack.v8.metadata.configuration.sections.common.CommonAttributes;
import com.minimajack.v8.metadata.configuration.sections.common.CommonModules;
import com.minimajack.v8.metadata.configuration.sections.common.CommonPictures;
import com.minimajack.v8.metadata.configuration.sections.common.CommonTemplates;
import com.minimajack.v8.metadata.configuration.sections.common.DefinedTypes;
import com.minimajack.v8.metadata.configuration.sections.common.EventSubscriptions;
import com.minimajack.v8.metadata.configuration.sections.common.ExchangePlans;
import com.minimajack.v8.metadata.configuration.sections.common.FilterCriteria;
import com.minimajack.v8.metadata.configuration.sections.common.FunctionalOptionParams;
import com.minimajack.v8.metadata.configuration.sections.common.FunctionalOptions;
import com.minimajack.v8.metadata.configuration.sections.common.HttpServices;
import com.minimajack.v8.metadata.configuration.sections.common.Interfaces;
import com.minimajack.v8.metadata.configuration.sections.common.Languages;
import com.minimajack.v8.metadata.configuration.sections.common.Roles;
import com.minimajack.v8.metadata.configuration.sections.common.ScheduledJobs;
import com.minimajack.v8.metadata.configuration.sections.common.SessionParams;
import com.minimajack.v8.metadata.configuration.sections.common.SettingsStorages;
import com.minimajack.v8.metadata.configuration.sections.common.StyleItems;
import com.minimajack.v8.metadata.configuration.sections.common.Styles;
import com.minimajack.v8.metadata.configuration.sections.common.Subsystems;
import com.minimajack.v8.metadata.configuration.sections.common.WebServices;
import com.minimajack.v8.metadata.configuration.sections.common.WsReferences;
import com.minimajack.v8.metadata.configuration.sections.common.XdtoPackages;
import com.minimajack.v8.metadata.configuration.sections.main.AccumulationRegisters;
import com.minimajack.v8.metadata.configuration.sections.main.Catalogs;
import com.minimajack.v8.metadata.configuration.sections.main.ChartsOfCharacteristicTypes;
import com.minimajack.v8.metadata.configuration.sections.main.CommandGroups;
import com.minimajack.v8.metadata.configuration.sections.main.CommonCommands;
import com.minimajack.v8.metadata.configuration.sections.main.CommonForms;
import com.minimajack.v8.metadata.configuration.sections.main.Constants;
import com.minimajack.v8.metadata.configuration.sections.main.DataProcessors;
import com.minimajack.v8.metadata.configuration.sections.main.DocumentJournals;
import com.minimajack.v8.metadata.configuration.sections.main.DocumentNumerators;
import com.minimajack.v8.metadata.configuration.sections.main.Documents;
import com.minimajack.v8.metadata.configuration.sections.main.Enums;
import com.minimajack.v8.metadata.configuration.sections.main.InformationRegisters;
import com.minimajack.v8.metadata.configuration.sections.main.Reports;
import com.minimajack.v8.metadata.configuration.sections.main.Sequences;
import com.minimajack.v8.metadata.external.attributes.AttributesSection;
import com.minimajack.v8.metadata.external.forms.FormDescription;
import com.minimajack.v8.metadata.external.forms.FormsSection;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.external.qualifier.QualityTransformer;
import com.minimajack.v8.metadata.external.tabularsection.TabularSections;
import com.minimajack.v8.metadata.external.template.TemplateDescription;
import com.minimajack.v8.metadata.external.template.TemplateSections;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;
import com.minimajack.v8.metadata.external.transformer.SectionTransformer;
import com.minimajack.v8.metadata.external.type.Types;
import com.minimajack.v8.metadata.external.type.TypesTransformer;
import com.minimajack.v8.metadata.root.V8Root;
import com.minimajack.v8.metadata.transformer.MetaDataDescription;
import com.minimajack.v8.metadata.transformer.V8MetaDataDescriptionTransformer;
import com.minimajack.v8.metadata.transformer.impl.CommonConfiguraionMetaData;
import com.minimajack.v8.metadata.transformer.impl.ExternalDataProcessorMetaData;
import com.minimajack.v8.metadata.transformer.impl.MainConfiguraionMetaData;
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.Project;
import com.minimajack.v8.project.ProjectTree;
import com.minimajack.v8.utility.V8Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class MetadataProcessor extends ProjectTreeSearcher {

  private final Path path;

  final Logger logger = LoggerFactory.getLogger(MetadataProcessor.class);

  private static final String METADATA_FILE = "metadata.mdo";

  private static final String TEMPLATES_PATH = "Templates";

  private static final String FORM_PATH = "Forms";

  private static final String LANGUAGES_PATH = "Languages";

  private static final String SUBSYSTEM_PATH = "Subsystems";

  private static final String SESSION_PARAMS_PATH = "SessionParams";

  private static final String COMMON_MODULES_PATH = "CommonModules";

  private static final String ROLES_PATH = "Roles";

  private static final String COMMON_ATTRIBUTES_PATH = "CommonAttributes";

  private static final String EXCHANGE_PLANS_PATH = "ExchangePlans";

  private static final String FILTER_CRITERIA_PATH = "FilterCriteria";

  private static final String EVENT_SUBSCRIPTIONS_PATH = "EventSubscriptions";

  private static final String SCHEDULED_JOBS_PATH = "ScheduledJobs";

  private static final String FUNCTIONAL_OPTIONS_PATH = "FunctionalOptions";

  private static final String FUNCTIONAL_OPTIONS_PARAMS_PATH = "FunctionalOptionParams";

  private static final String DEFINED_TYPES_PATH = "DefinedTypes";

  private static final String SETTINGS_STORAGES_PATH = "SettingsStorages";

  private static final String COMMON_TEMPLATES_PATH = "CommonTemplates";

  private static final String COMMON_PICTURES_PATH = "CommonPictures";

  private static final String XDTO_PACKAGES_PATH = "XDTOPackages";

  private static final String WEB_SERVICES_PATH = "WebServices";

  private static final String HTTP_SERVICES_PATH = "HTTPServices";

  private static final String WS_REFERENCES_PATH = "WSReferences";

  private static final String STYLE_ITEMS_PATH = "StyleItems";

  private static final String INTERFACES_PATH = "Interfaces";

  private static final String STYLES_PATH = "Styles";

  private static final String CONSTANTS_PATH = "Constants";

  private static final String DOCUMENTS_PATH = "Documents";

  private static final String COMMON_FORMS_PATH = "CommonForms";

  private static final String INFORMATION_REGISTERS_PATH = "InformationRegisters";

  private static final String COMMAND_GROUPS_PATH = "CommandGroups";

  private static final String COMMON_COMMANDS_PATH = "CommonCommands";

  private static final String DOCUMENT_NUMERATORS_PATH = "DocumentNumerators";

  private static final String DOCUMENT_JOURNALS_PATH = "DocumentJournals";

  private static final String REPORTS_PATH = "Reports";

  private static final String CHART_OF_CHARACTERITIC_TYPES_PATH = "ChartsOfCharacteristicTypes";

  private static final String ACCUMULATION_REGISTERS_PATH = "AccumulationRegisters";

  private static final String SEQUENCES_PATH = "Sequences";

  private static final String DATA_PROCESSORS_PATH = "DataProcessors";

  private static final String CATALOGS_PATH = "Catalogs";

  private static final String ENUMS_PATH = "Enums";

  public MetadataProcessor(final Path path) {
    super(path);
    this.path = path;
  }

  {
    new V8Reader();
    V8Reader.init();
    V8Reader.registerTransformer(MetadataSection.class, new SectionTransformer());
    V8Reader
        .registerTransformer(MetaDataDescription.class, new V8MetaDataDescriptionTransformer());
    V8Reader.registerTransformer(Qualifiers.class, new QualityTransformer());
    V8Reader.registerTransformer(Types.class, new TypesTransformer());

  }

  @Override
  public ProjectTree process(final ProjectTree tree) {

    final V8Root root = V8Reader.read(V8Root.class, getFileBuffer(tree, "root"));
    final V8MetaData md =
        V8Reader.read(V8MetaData.class, getFileBuffer(tree, root.guid.toString()));
    for (final MetaDataDescription v8Metadata : md.mdd) {
      if (v8Metadata.getType().equals(V8MetaDataDescriptionTransformer.EXTERNAL_DATA_PROCESSOR)) {
        processExternalDataProcessor(tree, (ExternalDataProcessorMetaData) v8Metadata);
      } else if (v8Metadata.getType()
          .equals(V8MetaDataDescriptionTransformer.COMMON_CONFIGURATION_BLOCK)) {
        processCommonConfigurationMetaData(tree, (CommonConfiguraionMetaData) v8Metadata);
      } else if (v8Metadata.getType()
          .equals(V8MetaDataDescriptionTransformer.MAIN_CONFIGURATION_BLOCK)) {
        processMainConfigurationMetaData(tree, (MainConfiguraionMetaData) v8Metadata);
      }
    }
    return tree;
  }

  private void processMainConfigurationMetaData(final ProjectTree tree,
      final MainConfiguraionMetaData v8MetaData) {
    for (final MetadataSection section : v8MetaData.innerType.mcbi.sections) {
      if (section instanceof Constants) {
        processConstants(tree, (Constants) section);
      } else if (section instanceof Documents) {
        processDocuments(tree, (Documents) section);
      } else if (section instanceof CommonForms) {
        processCommonForms(tree, (CommonForms) section);
      } else if (section instanceof InformationRegisters) {
        processInformationRegisters(tree, (InformationRegisters) section);
      } else if (section instanceof CommandGroups) {
        processCommandGroups(tree, (CommandGroups) section);
      } else if (section instanceof CommonCommands) {
        processCommonCommands(tree, (CommonCommands) section);
      } else if (section instanceof DocumentNumerators) {
        processDocumentNumerators(tree, (DocumentNumerators) section);
      } else if (section instanceof DocumentJournals) {
        processDocumentJournals(tree, (DocumentJournals) section);
      } else if (section instanceof Reports) {
        processReports(tree, (Reports) section);
      } else if (section instanceof ChartsOfCharacteristicTypes) {
        processChartsOfCharacteristicTypes(tree, (ChartsOfCharacteristicTypes) section);
      } else if (section instanceof AccumulationRegisters) {
        processAccumulationRegisters(tree, (AccumulationRegisters) section);
      } else if (section instanceof Sequences) {
        processSequences(tree, (Sequences) section);
      } else if (section instanceof DataProcessors) {
        processDataProcessors(tree, (DataProcessors) section);
      } else if (section instanceof Catalogs) {
        processCatalogs(tree, (Catalogs) section);
      } else if (section instanceof Enums) {
        processEnums(tree, (Enums) section);
      } else {
        throw new RuntimeException("NOT IMPLEMENTED" + section.getClass());
      }
    }
  }

  private void processEnums(final ProjectTree tree, final Enums v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + ENUMS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCatalogs(final ProjectTree tree, final Catalogs v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + CATALOGS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processDataProcessors(final ProjectTree tree, final DataProcessors v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + DATA_PROCESSORS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processSequences(final ProjectTree tree, final Sequences v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + SEQUENCES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processAccumulationRegisters(final ProjectTree tree,
      final AccumulationRegisters v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + ACCUMULATION_REGISTERS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processChartsOfCharacteristicTypes(final ProjectTree tree,
      final ChartsOfCharacteristicTypes v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + CHART_OF_CHARACTERITIC_TYPES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processReports(final ProjectTree tree, final Reports v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + REPORTS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processDocumentJournals(final ProjectTree tree, final DocumentJournals v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + DOCUMENT_JOURNALS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processDocumentNumerators(final ProjectTree tree,
      final DocumentNumerators v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + DOCUMENT_NUMERATORS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCommonCommands(final ProjectTree tree, final CommonCommands v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_COMMANDS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveLinkedContainerToFolder(tree, path2.toString() + ".2", destinationDir
          + path2.toString()
          + ".2");

    }
  }

  private void processCommandGroups(final ProjectTree tree, final CommandGroups v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMAND_GROUPS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processInformationRegisters(final ProjectTree tree,
      final InformationRegisters v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + INFORMATION_REGISTERS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCommonForms(final ProjectTree tree, final CommonForms v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_FORMS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveToFolder(tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0");

    }
  }

  private void processDocuments(final ProjectTree tree, final Documents v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + DOCUMENTS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processConstants(final ProjectTree tree, final Constants v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + CONSTANTS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCommonConfigurationMetaData(final ProjectTree tree,
      final CommonConfiguraionMetaData v8MetaData) {
    for (final MetadataSection section : v8MetaData.innerType.sections) {
      if (section instanceof Languages) {
        processLanguages(tree, (Languages) section);
      } else if (section instanceof Subsystems) {
        processSubsystems(tree, (Subsystems) section);
      } else if (section instanceof CommonModules) {
        processCommonModules(tree, (CommonModules) section);
      } else if (section instanceof SessionParams) {
        processSessionParams(tree, (SessionParams) section);
      } else if (section instanceof Roles) {
        processRoles(tree, (Roles) section);
      } else if (section instanceof CommonAttributes) {
        processCommonAttributes(tree, (CommonAttributes) section);
      } else if (section instanceof ExchangePlans) {
        processExchangePlans(tree, (ExchangePlans) section);
      } else if (section instanceof FilterCriteria) {
        processFilterCriteria(tree, (FilterCriteria) section);
      } else if (section instanceof EventSubscriptions) {
        processEventSubscriptions(tree, (EventSubscriptions) section);
      } else if (section instanceof ScheduledJobs) {
        processScheduledJobs(tree, (ScheduledJobs) section);
      } else if (section instanceof FunctionalOptions) {
        processFunctionalOptions(tree, (FunctionalOptions) section);
      } else if (section instanceof FunctionalOptionParams) {
        processFuctionalOptionParams(tree, (FunctionalOptionParams) section);
      } else if (section instanceof DefinedTypes) {
        processDefinedTypes(tree, (DefinedTypes) section);
      } else if (section instanceof SettingsStorages) {
        processSettingsStorages(tree, (SettingsStorages) section);
      } else if (section instanceof CommonTemplates) {
        processCommonTemplates(tree, (CommonTemplates) section);
      } else if (section instanceof CommonPictures) {
        processCommonPictures(tree, (CommonPictures) section);
      } else if (section instanceof XdtoPackages) {
        processXdtoPackages(tree, (XdtoPackages) section);
      } else if (section instanceof WebServices) {
        processWebServices(tree, (WebServices) section);
      } else if (section instanceof HttpServices) {
        processHttpServices(tree, (HttpServices) section);
      } else if (section instanceof WsReferences) {
        processWsReferences(tree, (WsReferences) section);
      } else if (section instanceof StyleItems) {
        processStyleItems(tree, (StyleItems) section);
      } else if (section instanceof Interfaces) {
        processInterfaces(tree, (Interfaces) section);
      } else if (section instanceof Styles) {
        processStyles(tree, (Styles) section);
      } else {
        throw new RuntimeException("Undefined section" + section.getClass());
      }
    }
  }

  private void processStyles(final ProjectTree tree, final Styles v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + STYLES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processInterfaces(final ProjectTree tree, final Interfaces v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + INTERFACES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveToFolder(tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0");

    }
  }

  private void processStyleItems(final ProjectTree tree, final StyleItems v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + STYLE_ITEMS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processWsReferences(final ProjectTree tree, final WsReferences v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + WS_REFERENCES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveLinkedContainerToFolder(tree, path2.toString() + ".0", destinationDir
          + path2.toString()
          + ".0");

    }
  }

  private void processHttpServices(final ProjectTree tree, final HttpServices v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + HTTP_SERVICES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processWebServices(final ProjectTree tree, final WebServices v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + WEB_SERVICES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processXdtoPackages(final ProjectTree tree, final XdtoPackages v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + XDTO_PACKAGES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCommonPictures(final ProjectTree tree, final CommonPictures v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_PICTURES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveToFolder(tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0");

    }
  }

  private void processCommonTemplates(final ProjectTree tree, final CommonTemplates v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_TEMPLATES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveToFolder(tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0");

    }
  }

  private void processSettingsStorages(final ProjectTree tree, final SettingsStorages v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + SETTINGS_STORAGES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processDefinedTypes(final ProjectTree tree, final DefinedTypes v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + DEFINED_TYPES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processFuctionalOptionParams(final ProjectTree tree,
      final FunctionalOptionParams v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + FUNCTIONAL_OPTIONS_PARAMS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processFunctionalOptions(final ProjectTree tree,
      final FunctionalOptions v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + FUNCTIONAL_OPTIONS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processScheduledJobs(final ProjectTree tree, final ScheduledJobs v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + SCHEDULED_JOBS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processEventSubscriptions(final ProjectTree tree,
      final EventSubscriptions v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + EVENT_SUBSCRIPTIONS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processFilterCriteria(final ProjectTree tree, final FilterCriteria v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + FILTER_CRITERIA_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processExchangePlans(final ProjectTree tree, final ExchangePlans v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + EXCHANGE_PLANS_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processCommonAttributes(final ProjectTree tree, final CommonAttributes v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_ATTRIBUTES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());

    }
  }

  private void processRoles(final ProjectTree tree, final Roles v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + ROLES_PATH
              + File.separator;

      moveToFolder(tree, path2.toString(), destinationDir + path2.toString());
      moveToFolder(tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0");

    }
  }

  private void processSessionParams(final ProjectTree tree, final SessionParams v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + SESSION_PARAMS_PATH
              + File.separator
              + path2.toString();

      moveToFolder(tree, path2.toString(), destinationDir);

    }
  }

  private void processLanguages(final ProjectTree tree, final Languages v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + LANGUAGES_PATH
              + File.separator
              + path2.toString();

      moveToFolder(tree, path2.toString(), destinationDir);

    }
  }

  private void processCommonModules(final ProjectTree tree, final CommonModules v8MetaData) {
    for (final UUID module : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + COMMON_MODULES_PATH
              + File.separator
              + module.toString();

      moveToFolder(tree, module.toString(), destinationDir);
      moveLinkedContainerToFolder(tree, module.toString() + ".0", destinationDir + ".0");

    }
  }

  private void processSubsystems(final ProjectTree tree, final Subsystems v8MetaData) {
    for (final UUID path2 : v8MetaData.uuids) {
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + SUBSYSTEM_PATH
              + File.separator
              + path2.toString();

      moveToFolder(tree, path2.toString(), destinationDir);

    }
  }

  private void processExternalDataProcessor(final ProjectTree tree,
      final ExternalDataProcessorMetaData v8MetaData) {
    for (final MetadataSection section : v8MetaData.innerType.sections) {
      if (section instanceof FormsSection) {
        this.logger.debug("FormSections size: {}", ((FormsSection) section).forms.size());
        processForms(tree, (FormsSection) section);

      } else if (section instanceof TabularSections) {
        this.logger
            .debug("TabularSections size: {}", ((TabularSections) section).tabularSections
                .size());
      } else if (section instanceof TemplateSections) {
        this.logger.debug("TemplateSection size: {}", ((TemplateSections) section).templates
            .size());
        processTemplates(tree, (TemplateSections) section);
      } else if (section instanceof AttributesSection) {
        this.logger.debug("Attributes size: {}", ((AttributesSection) section).descr.size());
      } else {
        this.logger.warn("Not implement section {}", section.getClass());
      }
    }
  }

  private void processTemplates(final ProjectTree tree, final TemplateSections templateSection) {
    for (final UUID template : templateSection.templates) {
      final String templateUuid = template.toString();
      final TemplateDescription description = getTemplateDescription(tree, templateUuid);
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + TEMPLATES_PATH
              + File.separator
              + description.templateInnerDescription.msn.name
              + File.separator;
      moveToFolder(tree, templateUuid, destinationDir + METADATA_FILE);
      moveLinkedContainerToFolder(tree, templateUuid + ".0", destinationDir);
      moveLinkedContainerToFolder(tree, templateUuid + ".1", destinationDir);
    }
  }

  private void processForms(final ProjectTree tree, final FormsSection formSection) {
    for (final UUID form : formSection.forms) {
      final String formUuid = form.toString();
      final FormDescription description = getFormDescription(tree, formUuid);
      final String destinationDir =
          this.path.toString()
              + File.separator
              + Project.SRC_PATH
              + File.separator
              + FORM_PATH
              + File.separator
              + description.formInnerDescription.md.ffmd.v8mn.name
              + File.separator;

      moveToFolder(tree, formUuid, destinationDir + METADATA_FILE);
      moveLinkedContainerToFolder(tree, formUuid + ".0", destinationDir);
      moveLinkedContainerToFolder(tree, formUuid + ".1", destinationDir);
    }
  }

  private TemplateDescription getTemplateDescription(final ProjectTree tree,
      final String template) {
    TemplateDescription description = null;
    try {
      description =
          V8Reader.read(TemplateDescription.class, getFileBuffer(tree, template.toString()));
    } catch (final Exception e) {
      this.logger.warn("Error while parsing template {}", template);
    }

    return description;
  }

  private FormDescription getFormDescription(final ProjectTree tree, final String form) {
    FormDescription description = null;
    try {
      description = V8Reader.read(FormDescription.class, getFileBuffer(tree, form.toString()));
    } catch (final Exception e) {
      this.logger.warn("Error while parsing form {}", form);
    }

    return description;
  }

  private void moveLinkedContainerToFolder(final ProjectTree tree, final String name,
      final String dest) {
    final ProjectTree pt = findFileByName(tree, name);
    if (pt != null && pt.type != FileType.ERROR) {
      if (pt.type.equals(FileType.CONTAINER)) {
        final Path p = pt.getRawPath();
        final String destination = this.path.relativize(Paths.get(dest)).toString();
        for (final ProjectTree child : pt.child) {
          final Path simplename = p.relativize(child.getRawPath());
          final Path abolute =
              Paths.get(this.path.toString()
                  + File.separator
                  + destination
                  + File.separator
                  + simplename.toString());

          moveToFolder(child, child.name, abolute.toString());
        }
        Paths.get(this.path.toAbsolutePath() + File.separator + pt.getRawPath().toString())
            .toFile().delete();
        pt.setPath(destination);
      } else if (pt.type.equals(FileType.FILE)) {
        moveToFolder(tree, name, dest + File.separator + pt.getName());
      }
    }
  }

  private void moveToFolder(final ProjectTree tree, final String name, final String dest) {
    final ProjectTree pt = findFileByName(tree, name);
    final Path p = Paths.get(this.path.toString() + File.separator + pt.getPath());
    final File file = p.toFile();
    final File destName = new File(dest);
    destName.getParentFile().mkdirs();
    if (destName.exists()) {
      if (!destName.delete()) {
        throw new RuntimeException("Can't delete previous file");
      }
    }
    if (file.renameTo(destName)) {
      pt.setPath(this.path.relativize(destName.toPath().toAbsolutePath()).toString());
    } else {
      this.logger.warn("Can't move {} to {} ", p, dest);
    }
  }
}

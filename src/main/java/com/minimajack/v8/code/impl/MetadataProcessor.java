package com.minimajack.v8.code.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.code.ProjectTreeSearcher;
import com.minimajack.v8.metadata.V8MetaData;
import com.minimajack.v8.metadata.configuration.sections.common.*;
import com.minimajack.v8.metadata.configuration.sections.main.*;
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

public class MetadataProcessor
    extends ProjectTreeSearcher
{
    private Path path;

    final Logger logger = LoggerFactory.getLogger( MetadataProcessor.class );

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

    public MetadataProcessor( Path path )
    {
        super( path );
        this.path = path;
    }

    {
        new V8Reader();
        V8Reader.init();
        V8Reader.registerTransformer( MetadataSection.class, new SectionTransformer() );
        V8Reader.registerTransformer( MetaDataDescription.class, new V8MetaDataDescriptionTransformer() );
        V8Reader.registerTransformer( Qualifiers.class, new QualityTransformer() );
        V8Reader.registerTransformer( Types.class, new TypesTransformer() );

    }

    @Override
    public ProjectTree process( ProjectTree tree )
    {

        V8Root root = V8Reader.read( V8Root.class, getFileBuffer( tree, "root" ) );
        V8MetaData md = V8Reader.read( V8MetaData.class, getFileBuffer( tree, root.guid.toString() ) );
        for ( MetaDataDescription v8MD : md.mdd )
        {
            if ( v8MD.getType().equals( V8MetaDataDescriptionTransformer.EXTERNAL_DATA_PROCESSOR ) )
            {
                processExternalDataProcessor( tree, (ExternalDataProcessorMetaData) v8MD );
            }
            else if ( v8MD.getType().equals( V8MetaDataDescriptionTransformer.COMMON_CONFIGURATION_BLOCK ) )
            {
                processCommonConfigurationMetaData( tree, (CommonConfiguraionMetaData) v8MD );
            }
            else if ( v8MD.getType().equals( V8MetaDataDescriptionTransformer.MAIN_CONFIGURATION_BLOCK ) )
            {
                processMainConfigurationMetaData( tree, (MainConfiguraionMetaData) v8MD );
            }
        }
        return tree;
    }

    private void processMainConfigurationMetaData( ProjectTree tree, MainConfiguraionMetaData v8MD )
    {
        for ( MetadataSection section : v8MD.innerType.mcbi.sections )
        {
            if ( section instanceof Constants )
            {
                processConstants( tree, (Constants) section );
            }
            else if ( section instanceof Documents )
            {
                processDocuments( tree, (Documents) section );
            }
            else if ( section instanceof CommonForms )
            {
                processCommonForms( tree, (CommonForms) section );
            }
            else if ( section instanceof InformationRegisters )
            {
                processInformationRegisters( tree, (InformationRegisters) section );
            }
            else if ( section instanceof CommandGroups )
            {
                processCommandGroups( tree, (CommandGroups) section );
            }
            else if ( section instanceof CommonCommands )
            {
                processCommonCommands( tree, (CommonCommands) section );
            }
            else if ( section instanceof DocumentNumerators )
            {
                processDocumentNumerators( tree, (DocumentNumerators) section );
            }
            else if ( section instanceof DocumentJournals )
            {
                processDocumentJournals( tree, (DocumentJournals) section );
            }
            else if ( section instanceof Reports )
            {
                processReports( tree, (Reports) section );
            }
            else if ( section instanceof ChartsOfCharacteristicTypes )
            {
                processChartsOfCharacteristicTypes( tree, (ChartsOfCharacteristicTypes) section );
            }
            else if ( section instanceof AccumulationRegisters )
            {
                processAccumulationRegisters( tree, (AccumulationRegisters) section );
            }
            else if ( section instanceof Sequences )
            {
                processSequences( tree, (Sequences) section );
            }
            else if ( section instanceof DataProcessors )
            {
                processDataProcessors( tree, (DataProcessors) section );
            }
            else if ( section instanceof Catalogs )
            {
                processCatalogs( tree, (Catalogs) section );
            }
            else if ( section instanceof Enums )
            {
                processEnums( tree, (Enums) section );
            }
            else
            {
                throw new RuntimeException( "NOT IMPLEMENTED" + section.getClass() );
            }
        }
    }

    private void processEnums( ProjectTree tree, Enums v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + ENUMS_PATH
                + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCatalogs( ProjectTree tree, Catalogs v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + CATALOGS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processDataProcessors( ProjectTree tree, DataProcessors v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + DATA_PROCESSORS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processSequences( ProjectTree tree, Sequences v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + SEQUENCES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processAccumulationRegisters( ProjectTree tree, AccumulationRegisters v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + ACCUMULATION_REGISTERS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processChartsOfCharacteristicTypes( ProjectTree tree, ChartsOfCharacteristicTypes v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + CHART_OF_CHARACTERITIC_TYPES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processReports( ProjectTree tree, Reports v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + REPORTS_PATH
                + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processDocumentJournals( ProjectTree tree, DocumentJournals v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + DOCUMENT_JOURNALS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processDocumentNumerators( ProjectTree tree, DocumentNumerators v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + DOCUMENT_NUMERATORS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCommonCommands( ProjectTree tree, CommonCommands v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_COMMANDS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveLinkedContainerToFolder( tree, path2.toString() + ".2", destinationDir + path2.toString() + ".2" );

        }
    }

    private void processCommandGroups( ProjectTree tree, CommandGroups v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMAND_GROUPS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processInformationRegisters( ProjectTree tree, InformationRegisters v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + INFORMATION_REGISTERS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCommonForms( ProjectTree tree, CommonForms v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_FORMS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processDocuments( ProjectTree tree, Documents v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + DOCUMENTS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processConstants( ProjectTree tree, Constants v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + CONSTANTS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCommonConfigurationMetaData( ProjectTree tree, CommonConfiguraionMetaData v8MD )
    {
        for ( MetadataSection section : v8MD.innerType.sections )
        {
            if ( section instanceof Languages )
            {
                processLanguages( tree, (Languages) section );
            }
            else if ( section instanceof Subsystems )
            {
                processSubsystems( tree, (Subsystems) section );
            }
            else if ( section instanceof CommonModules )
            {
                processCommonModules( tree, (CommonModules) section );
            }
            else if ( section instanceof SessionParams )
            {
                processSessionParams( tree, (SessionParams) section );
            }
            else if ( section instanceof Roles )
            {
                processRoles( tree, (Roles) section );
            }
            else if ( section instanceof CommonAttributes )
            {
                processCommonAttributes( tree, (CommonAttributes) section );
            }
            else if ( section instanceof ExchangePlans )
            {
                processExchangePlans( tree, (ExchangePlans) section );
            }
            else if ( section instanceof FilterCriteria )
            {
                processFilterCriteria( tree, (FilterCriteria) section );
            }
            else if ( section instanceof EventSubscriptions )
            {
                processEventSubscriptions( tree, (EventSubscriptions) section );
            }
            else if ( section instanceof ScheduledJobs )
            {
                processScheduledJobs( tree, (ScheduledJobs) section );
            }
            else if ( section instanceof FunctionalOptions )
            {
                processFunctionalOptions( tree, (FunctionalOptions) section );
            }
            else if ( section instanceof FunctionalOptionParams )
            {
                processFuctionalOptionParams( tree, (FunctionalOptionParams) section );
            }
            else if ( section instanceof DefinedTypes )
            {
                processDefinedTypes( tree, (DefinedTypes) section );
            }
            else if ( section instanceof SettingsStorages )
            {
                processSettingsStorages( tree, (SettingsStorages) section );
            }
            else if ( section instanceof CommonTemplates )
            {
                processCommonTemplates( tree, (CommonTemplates) section );
            }
            else if ( section instanceof CommonPictures )
            {
                processCommonPictures( tree, (CommonPictures) section );
            }
            else if ( section instanceof XDTOPackages )
            {
                processXDTOPackages( tree, (XDTOPackages) section );
            }
            else if ( section instanceof WebServices )
            {
                processWebServices( tree, (WebServices) section );
            }
            else if ( section instanceof HTTPServices )
            {
                processHTTPServices( tree, (HTTPServices) section );
            }
            else if ( section instanceof WSReferences )
            {
                processWSReferences( tree, (WSReferences) section );
            }
            else if ( section instanceof StyleItems )
            {
                processStyleItems( tree, (StyleItems) section );
            }
            else if ( section instanceof Interfaces )
            {
                processInterfaces( tree, (Interfaces) section );
            }
            else if ( section instanceof Styles )
            {
                processStyles( tree, (Styles) section );
            }
            else
            {
                throw new RuntimeException( "Undefined section" + section.getClass() );
            }
        }
    }

    private void processStyles( ProjectTree tree, Styles v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + STYLES_PATH
                + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processInterfaces( ProjectTree tree, Interfaces v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + INTERFACES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processStyleItems( ProjectTree tree, StyleItems v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + STYLE_ITEMS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processWSReferences( ProjectTree tree, WSReferences v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + WS_REFERENCES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveLinkedContainerToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processHTTPServices( ProjectTree tree, HTTPServices v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + HTTP_SERVICES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processWebServices( ProjectTree tree, WebServices v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + WEB_SERVICES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processXDTOPackages( ProjectTree tree, XDTOPackages v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + XDTO_PACKAGES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCommonPictures( ProjectTree tree, CommonPictures v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_PICTURES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processCommonTemplates( ProjectTree tree, CommonTemplates v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_TEMPLATES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processSettingsStorages( ProjectTree tree, SettingsStorages v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + SETTINGS_STORAGES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processDefinedTypes( ProjectTree tree, DefinedTypes v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + DEFINED_TYPES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processFuctionalOptionParams( ProjectTree tree, FunctionalOptionParams v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + FUNCTIONAL_OPTIONS_PARAMS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processFunctionalOptions( ProjectTree tree, FunctionalOptions v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + FUNCTIONAL_OPTIONS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processScheduledJobs( ProjectTree tree, ScheduledJobs v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + SCHEDULED_JOBS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processEventSubscriptions( ProjectTree tree, EventSubscriptions v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + EVENT_SUBSCRIPTIONS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processFilterCriteria( ProjectTree tree, FilterCriteria v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + FILTER_CRITERIA_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processExchangePlans( ProjectTree tree, ExchangePlans v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + EXCHANGE_PLANS_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processCommonAttributes( ProjectTree tree, CommonAttributes v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_ATTRIBUTES_PATH + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );

        }
    }

    private void processRoles( ProjectTree tree, Roles v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + ROLES_PATH
                + File.separator;

            moveToFolder( tree, path2.toString(), destinationDir + path2.toString() );
            moveToFolder( tree, path2.toString() + ".0", destinationDir + path2.toString() + ".0" );

        }
    }

    private void processSessionParams( ProjectTree tree, SessionParams v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + SESSION_PARAMS_PATH + File.separator + path2.toString();

            moveToFolder( tree, path2.toString(), destinationDir );

        }
    }

    private void processLanguages( ProjectTree tree, Languages v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + LANGUAGES_PATH + File.separator + path2.toString();

            moveToFolder( tree, path2.toString(), destinationDir );

        }
    }

    private void processCommonModules( ProjectTree tree, CommonModules v8MD )
    {
        for ( UUID module : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + COMMON_MODULES_PATH + File.separator + module.toString();

            moveToFolder( tree, module.toString(), destinationDir );
            moveLinkedContainerToFolder( tree, module.toString() + ".0", destinationDir + ".0" );

        }
    }

    private void processSubsystems( ProjectTree tree, Subsystems v8MD )
    {
        for ( UUID path2 : v8MD.uuids )
        {
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + SUBSYSTEM_PATH + File.separator + path2.toString();

            moveToFolder( tree, path2.toString(), destinationDir );

        }
    }

    private void processExternalDataProcessor( ProjectTree tree, ExternalDataProcessorMetaData v8MD )
    {
        for ( MetadataSection section : v8MD.innerType.sections )
        {
            if ( section instanceof FormsSection )
            {
                logger.debug( "FormSections size: {}", ( (FormsSection) section ).forms.size() );
                processForms( tree, (FormsSection) section );

            }
            else if ( section instanceof TabularSections )
            {
                logger.debug( "TabularSections size: {}", ( (TabularSections) section ).tabularSections.size() );
            }
            else if ( section instanceof TemplateSections )
            {
                logger.debug( "TemplateSection size: {}", ( (TemplateSections) section ).templates.size() );
                processTemplates( tree, (TemplateSections) section );
            }
            else if ( section instanceof AttributesSection )
            {
                logger.debug( "Attributes size: {}", ( (AttributesSection) section ).descr.size() );
            }
            else
            {
                logger.warn( "Not implement section {}", section.getClass() );
            }
        }
    }

    private void processTemplates( ProjectTree tree, TemplateSections templateSection )
    {
        for ( UUID template : templateSection.templates )
        {
            String templateUUID = template.toString();
            TemplateDescription description = getTemplateDescription( tree, templateUUID );
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + TEMPLATES_PATH + File.separator + description.templateInnerDescription.msn.name + File.separator;
            moveToFolder( tree, templateUUID, destinationDir + METADATA_FILE );
            moveLinkedContainerToFolder( tree, templateUUID + ".0", destinationDir );
            moveLinkedContainerToFolder( tree, templateUUID + ".1", destinationDir );
        }
    }

    private void processForms( ProjectTree tree, FormsSection formSection )
    {
        for ( UUID form : formSection.forms )
        {
            String formUUID = form.toString();
            FormDescription description = getFormDescription( tree, formUUID );
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + FORM_PATH
                + File.separator + description.formInnerDescription.md.ffmd.v8mn.name + File.separator;

            moveToFolder( tree, formUUID, destinationDir + METADATA_FILE );
            moveLinkedContainerToFolder( tree, formUUID + ".0", destinationDir );
            moveLinkedContainerToFolder( tree, formUUID + ".1", destinationDir );
        }
    }

    private TemplateDescription getTemplateDescription( ProjectTree tree, String template )
    {
        TemplateDescription description = null;
        try
        {
            description = V8Reader.read( TemplateDescription.class, getFileBuffer( tree, template.toString() ) );
        }
        catch ( Exception e )
        {
            logger.warn( "Error while parsing template {}", template );
        }

        return description;
    }

    private FormDescription getFormDescription( ProjectTree tree, String form )
    {
        FormDescription description = null;
        try
        {
            description = V8Reader.read( FormDescription.class, getFileBuffer( tree, form.toString() ) );
        }
        catch ( Exception e )
        {
            logger.warn( "Error while parsing form {}", form );
        }

        return description;
    }

    private void moveLinkedContainerToFolder( ProjectTree tree, String name, String dest )
    {
        ProjectTree pt = this.findFileByName( tree, name );
        if ( pt != null && pt.type != FileType.ERROR )
        {
            if ( pt.type.equals( FileType.CONTAINER ) )
            {
                Path p = pt.getRawPath();
                String destination = path.relativize( Paths.get( dest ) ).toString();
                for ( ProjectTree child : pt.child )
                {
                    Path simplename = p.relativize( child.getRawPath() );
                    Path abolute = Paths.get( this.path.toString() + File.separator + destination + File.separator
                        + simplename.toString() );

                    moveToFolder( child, child.name, abolute.toString() );
                }
                Paths.get( path.toAbsolutePath() + File.separator + pt.getRawPath().toString() ).toFile().delete();
                pt.setPath( destination );
            }
            else if ( pt.type.equals( FileType.FILE ) )
            {
                moveToFolder( tree, name, dest + File.separator + pt.getName() );
            }
        }
    }

    private void moveToFolder( ProjectTree tree, String name, String dest )
    {
        ProjectTree pt = this.findFileByName( tree, name );
        Path p = Paths.get( path.toString() + File.separator + pt.getPath() );
        File file = p.toFile();
        File destName = new File( dest );
        destName.getParentFile().mkdirs();
        if ( destName.exists() )
        {
            destName.delete();
        }
        if ( file.renameTo( destName ) )
        {
            pt.setPath( path.relativize( destName.toPath().toAbsolutePath() ).toString() );
        }
        else
        {
            logger.warn( "Can't move {} to {} ", p, dest );
        }
    }
}

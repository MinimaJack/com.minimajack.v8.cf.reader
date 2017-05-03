package com.minimajack.v8.code.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minimajack.v8.code.ProjectTreeSearcher;
import com.minimajack.v8.metadata.external.V8MetaData;
import com.minimajack.v8.metadata.external.V8MetaDataDescription;
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
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.Project;
import com.minimajack.v8.project.ProjectTree;
import com.minimajack.v8.utility.V8Reader;

public class MetadataProcessor
    extends ProjectTreeSearcher
{
    private Path path;

    final Logger logger = LoggerFactory.getLogger( MetadataProcessor.class );

    private static final UUID EXTERNAL_DATA_PROCESSOR = UUID.fromString( "c3831ec8-d8d5-4f93-8a22-f9bfae07327f" );

    private static final String TEMPLATES_PATH = "Templates";

    private static final String FORM_PATH = "Forms";

    private static final String METADATA_FILE = "metadata.mdo";

    public MetadataProcessor( Path path )
    {
        super( path );
        this.path = path;
    }

    {
        new V8Reader();
        V8Reader.init();
        V8Reader.registerTransformer( MetadataSection.class, new SectionTransformer() );
        V8Reader.registerTransformer( Qualifiers.class, new QualityTransformer() );
        V8Reader.registerTransformer( Types.class, new TypesTransformer() );

    }

    @Override
    public ProjectTree process( ProjectTree tree )
    {

        V8Root root = V8Reader.read( V8Root.class, getFileBuffer( tree, "root" ) );
        V8MetaData md = V8Reader.read( V8MetaData.class, getFileBuffer( tree, root.guid.toString() ) );
        for ( V8MetaDataDescription v8MD : md.mdd )
        {
            if ( v8MD.type.equals( EXTERNAL_DATA_PROCESSOR ) )
            {
                processExternalDataProcessor( tree, v8MD );
            }
        }
        return tree;
    }

    private void processExternalDataProcessor( ProjectTree tree, V8MetaDataDescription v8MD )
    {
        for ( MetadataSection section : v8MD.innerType.sections )
        {
            if ( section instanceof FormsSection )
            {
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
            TemplateDescription description = getTemplateDescription( tree, template.toString() );
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator
                + TEMPLATES_PATH + File.separator + description.templateInnerDescription.msn.name + File.separator;
            moveToFolder( tree, template.toString(), destinationDir + METADATA_FILE );
            moveLinkedContainerToFolder( tree, template.toString(), destinationDir );
        }
    }

    private void processForms( ProjectTree tree, FormsSection formSection )
    {
        for ( UUID form : formSection.forms )
        {
            FormDescription description = getFormDescription( tree, form.toString() );
            String destinationDir = path.toString() + File.separator + Project.SRC_PATH + File.separator + FORM_PATH
                + File.separator + description.formInnerDescription.md.ffmd.v8mn.name + File.separator;

            moveToFolder( tree, form.toString(), destinationDir + METADATA_FILE );
            moveLinkedContainerToFolder( tree, form.toString(), destinationDir );
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
        String subName = name + ".0"; //TODO fix by metadata
        ProjectTree pt = this.findFileByName( tree, subName );
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
            moveToFolder( tree, subName, dest + File.separator + pt.getName() );
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

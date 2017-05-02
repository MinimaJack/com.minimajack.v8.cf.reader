package com.minimajack.v8.code.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.minimajack.v8.code.ProjectTreeSearcher;
import com.minimajack.v8.metadata.external.V8MetaData;
import com.minimajack.v8.metadata.external.V8MetaDataDescription;
import com.minimajack.v8.metadata.external.forms.V8MetaFormsSection;
import com.minimajack.v8.metadata.external.qualifier.Qualifiers;
import com.minimajack.v8.metadata.external.qualifier.QualityTransformer;
import com.minimajack.v8.metadata.external.transformer.MetadataSection;
import com.minimajack.v8.metadata.external.transformer.SectionTransformer;
import com.minimajack.v8.metadata.root.V8Root;
import com.minimajack.v8.project.Project;
import com.minimajack.v8.project.ProjectTree;
import com.minimajack.v8.utility.V8Reader;

public class MetadataProcessor
    extends ProjectTreeSearcher
{
    private Path path;

    private static final UUID External_DP = UUID.fromString( "c3831ec8-d8d5-4f93-8a22-f9bfae07327f" );

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

    }

    @Override
    public ProjectTree process( ProjectTree tree )
    {

        V8Root root = V8Reader.read( V8Root.class, getFileBuffer( tree, "root" ) );
        V8MetaData md = V8Reader.read( V8MetaData.class, getFileBuffer( tree, root.guid.toString() ) );
        for ( V8MetaDataDescription v8MD : md.mdd )
        {
            if ( v8MD.type.equals( External_DP ) )
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
            if ( section instanceof V8MetaFormsSection )
            {
                for ( UUID form : ( (V8MetaFormsSection) section ).forms )
                {
                    System.out.println( "Form: " + form );
                    moveToFolder( tree, form.toString(), path.toString() + File.separator + Project.SRC_PATH
                        + File.separator + "Forms" + File.separator + form );
                }
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
        System.out.println( dest );
        if ( file.renameTo( destName ) )
        {
            pt.setPath( path.relativize( destName.toPath().toAbsolutePath() ).toString() );
        }
    }
}

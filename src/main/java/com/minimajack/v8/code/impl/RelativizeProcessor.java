package com.minimajack.v8.code.impl;

import java.nio.file.Path;

import com.minimajack.v8.code.Processor;
import com.minimajack.v8.project.ProjectTree;

public class RelativizeProcessor
    implements Processor<ProjectTree>
{
    private Path path;

    public RelativizeProcessor( Path path )
    {
        this.path = path;
    }

    @Override
    public ProjectTree process( ProjectTree t )
    {
        ProjectTree current = t;
        current.setPath( path.relativize( current.getRawPath().toAbsolutePath() ).toString() );
        for ( ProjectTree pt : current.getChild() )
        {
            this.process( pt );
        }
        return t;
    }

}

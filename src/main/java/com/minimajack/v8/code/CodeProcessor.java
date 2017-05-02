package com.minimajack.v8.code;

import java.util.LinkedList;

import com.minimajack.v8.project.ProjectTree;

public class CodeProcessor
    implements Processor<ProjectTree>
{

    LinkedList<Processor<ProjectTree>> processors = new LinkedList<Processor<ProjectTree>>();

    @Override
    public ProjectTree process( ProjectTree t )
    {
        for ( Processor<ProjectTree> processor : processors )
        {
            t = processor.process( t );
        }
        return t;
    }

    public void addProcessor( Processor<ProjectTree> processor )
    {
        processors.add( processor );
    }
}

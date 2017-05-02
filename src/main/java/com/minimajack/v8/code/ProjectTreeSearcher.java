package com.minimajack.v8.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.project.ProjectTree;

public abstract class ProjectTreeSearcher
    implements Processor<ProjectTree>
{
    Path path;

    public ProjectTreeSearcher( Path path )
    {
        this.path = path;
    }

    public ByteBuffer getFileBuffer( ProjectTree tree, String name )
    {
        ProjectTree file = findFileByName( tree, name );
        ByteBuffer bb = null;
        try
        {
            bb = ByteBuffer
                .wrap( ByteStreams.toByteArray( new FileInputStream( path + File.separator + file.getPath() ) ) );
            bb.position( 3 );
            return bb;
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        return bb;
    }

    public ProjectTree findFileByName( ProjectTree tree, String name )
    {
        ProjectTree current = tree;
        ProjectTree result = null;
        if ( tree.name.equals( name ) )
        {
            result = tree;
        }
        else
        {
            for ( ProjectTree pt : current.getChild() )
            {
                result = this.findFileByName( pt, name );
                if ( result != null )
                {
                    break;
                }
            }
        }
        return result;

    }
}

package com.minimajack.v8.project;

import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "type", "path", "child" })
public class ProjectTree
{
    @XmlTransient
    public Path path;

    @XmlElement
    public FileType type;

    @XmlTransient
    public ArrayList<ProjectTree> child = new ArrayList<ProjectTree>();

    public ProjectTree()
    {

    }

    public ProjectTree( Path path, FileType type )
    {
        super();
        this.path = path;
        this.type = type;
    }

    @XmlElement
    public String getPath()
    {
        return path.toString();
    }

    public void setPath( Path path )
    {
        this.path = path;
    }

    public void relativize( Path path )
    {
        if ( this.path != null )
        {
            this.setPath( path.relativize( this.path.toAbsolutePath() ) );
        }
        child.forEach( e -> e.relativize( path ) );
    }

    @XmlTransient
    public FileType getType()
    {
        return type;
    }

    public void setType( FileType type )
    {
        this.type = type;
    }

    @XmlElement
    public ArrayList<ProjectTree> getChild()
    {
        return child;
    }

    public void addChild( ProjectTree child )
    {
        this.child.add( child );
    }

}

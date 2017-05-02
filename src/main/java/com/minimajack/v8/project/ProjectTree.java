package com.minimajack.v8.project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "type", "name", "path", "child" })
public class ProjectTree
{
    @XmlTransient
    private Path path;

    @XmlElement
    public FileType type;

    @XmlElement
    public String name;

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

    @XmlTransient
    public Path getRawPath()
    {
        return path;
    }

    public void setPath( String path )
    {
        this.path = Paths.get( path );
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

    @XmlTransient
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

}

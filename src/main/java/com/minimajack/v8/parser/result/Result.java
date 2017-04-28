package com.minimajack.v8.parser.result;

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
public class Result
{
    @XmlTransient
    public Path path;

    @XmlElement
    public ResultType type;

    @XmlTransient
    public ArrayList<Result> child = new ArrayList<Result>();

    public Result()
    {

    }

    public Result( Path path, ResultType type )
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
    public ResultType getType()
    {
        return type;
    }

    public void setType( ResultType type )
    {
        this.type = type;
    }

    @XmlElement
    public ArrayList<Result> getChild()
    {
        return child;
    }

    public void addChild( Result child )
    {
        this.child.add( child );
    }

}

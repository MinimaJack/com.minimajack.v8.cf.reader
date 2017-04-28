package com.minimajack.v8.parser.result;

import java.nio.file.Path;

public class Result
{
    Path path;

    ResultType type;

    public Result( Path path, ResultType type )
    {
        super();
        this.path = path;
        this.type = type;
    }

    public Path getPath()
    {
        return path;
    }

    public void setPath( Path path )
    {
        this.path = path;
    }

    public ResultType getType()
    {
        return type;
    }

    public void setType( ResultType type )
    {
        this.type = type;
    }

}

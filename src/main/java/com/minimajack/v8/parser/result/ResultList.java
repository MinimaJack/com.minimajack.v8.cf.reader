package com.minimajack.v8.parser.result;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

public class ResultList
{
    LinkedBlockingQueue<Result> results = new LinkedBlockingQueue<Result>();

    public void addResult( Result result )
    {
        results.add( result );
    }

    public void merge( ResultList resultList )
    {
        results.addAll( resultList.getResults() );
    }

    public Collection<? extends Result> getResults()
    {
        return results;
    }

}

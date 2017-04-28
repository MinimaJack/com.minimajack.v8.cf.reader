package com.minimajack.v8.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.Container;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.Strategy;
import com.minimajack.v8.io.StrategyHolder;
import com.minimajack.v8.io.reader.AbstractReader;
import com.minimajack.v8.model.Context;
import com.minimajack.v8.parser.ParserTask;
import com.minimajack.v8.parser.result.Result;
import com.minimajack.v8.parser.result.ResultType;

@SuppressWarnings("serial")
public class ContainerParserTask
    extends ParserTask
    implements AbstractReader, StrategyHolder
{
    final Logger logger = LoggerFactory.getLogger( ContainerParserTask.class );

    /**
     * 
     */
    private Context context;

    private Container container;

    private Strategy strategy;

    @Override
    public Context getContext()
    {
        return context;
    }

    @Override
    public void setContext( Context context )
    {
        this.context = context;
    }

    @Override
    public void read()
    {
        try
        {
            ForkJoinPool.commonPool().invoke( this );
        }
        catch ( Exception e )
        {
            logger.error( "Error while parsing container", e );
        }

    }

    @Override
    public void setContainer( Container container )
    {
        this.container = container;
    }

    @Override
    public Result compute()
    {
        LinkedList<ParserTask> tasks = new LinkedList<ParserTask>();
        Result result = new Result( new File( this.getContext().getPath() ).toPath(), ResultType.CONTAINER );

        try
        {
            container.read();
            container.getFileSystem().read();
            container.getFileSystem().readFiles();
            List<V8File> v8list = container.getFileSystem().getV8FileList();
            for ( V8File f : v8list )
            {
                if ( f.isContainer() )
                {
                    Context childContext = f.getContext().createChildContext( f.getAttributes().getName().trim() );
                    Container childContainer = new Container( ByteStreams.toByteArray( f.getBody().getInputStream() ) );
                    childContainer.setContext( childContext );
                    ContainerParserTask reader = new ContainerParserTask();
                    reader.setStrategy( getStrategy() );
                    reader.setContext( childContext );
                    reader.setContainer( childContainer );
                    tasks.add( reader );
                }
                else
                {
                    switch ( getStrategy() )
                    {
                        case MODIFYDATE:
                            tasks.add( new VirtualCachedFileParserTask( f ) );
                            break;
                        case NONCACHE:
                            tasks.add( new VirtualFileParserTask( f ) );
                            break;
                        default:
                            break;
                    }

                }
            }

            Collection<ParserTask> taskResults = ForkJoinTask.invokeAll( tasks );
            for ( ParserTask parserTask : taskResults )
            {
                result.addChild( parserTask.getRawResult() );
            }
        }
        catch ( IOException e )
        {
            logger.error( "Error while parsing container", e );
        }
        catch ( OutOfMemoryError e )
        {
            logger.error( "Out of memory", e );
        }
        container.cleanUp();
        return result;
    }

    @Override
    public Strategy getStrategy()
    {
        return this.strategy;
    }

    @Override
    public void setStrategy( Strategy strategy )
    {
        this.strategy = strategy;

    }

}
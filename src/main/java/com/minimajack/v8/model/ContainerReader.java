package com.minimajack.v8.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.Container;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.io.reader.AbstractReader;
import com.minimajack.v8.threadpool.CommonThreadPoolManager;

public class ContainerReader
    extends AbstractReader
    implements Runnable
{

    /**
     * 
     */
    private Context context;

    private Container container;

    @SuppressWarnings("restriction")
    private final File getOrCreateFile( V8File v8File )
        throws IOException
    {
        String name = v8File.getAttributes().getName();
        String path = v8File.getContext().getPath();
        File file = new File( path );
        file.mkdirs();
        file = new File( path + "/" + name.trim() + ".txt" );
        if ( !file.exists() )
        {
            try
            {
                file.createNewFile();
            }
            catch ( Exception e )
            {
                String newname = new String( new sun.misc.BASE64Encoder().encode( name.trim().getBytes() ) );
                newname = newname.substring( 0, newname.length() - 1 );
                System.out.println( "Rename " + name + " to " + newname );
                file = new File( path + "/" + newname + ".txt" );
                file.createNewFile();
            }
        }
        return file;
    }

    @Override
    public void run()
    {
        try
        {
            container.read();
            container.getFileSystem().read();
            container.getFileSystem().readFiles();
            container.getFileSystem().iterate( new Visitor<V8File>()
            {

                @Override
                public void visit( V8File v8File )
                {
                    try
                    {
                        if ( v8File.isContainer() )
                        {
                            Context childContext = v8File.getContext().createChildContext( v8File.getAttributes()
                                                                                               .getName().trim() );
                            childContext.setReader( ContainerReader.class );
                            byte[] data = new byte[v8File.getBody().getDocSize()];
                            ByteStreams.readFully( v8File.getBody().getInputStream(), data );
                            Container childContainer = new Container( data );
                            childContainer.setContext( childContext );

                            childContext.parseContainer( childContainer );

                        }
                        else
                        {
                            File destination = getOrCreateFile( v8File );
                            InputStream dataStream = v8File.getBody().getDataStream();
                            try (OutputStream fos = new BufferedOutputStream( new FileOutputStream( destination ) ))
                            {
                                ByteStreams.copy( dataStream, fos );
                                dataStream.close();
                            }
                            catch ( Exception e )
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                }
            } );
            container.cleanUp();
            CountHolder.decrement();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

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
        CountHolder.increment();
        CommonThreadPoolManager.getInstance().executeInstant( this );
    }

    @Override
    public void setContainer( Container container )
    {
        this.container = container;
    }

}
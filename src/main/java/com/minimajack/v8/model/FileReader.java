package com.minimajack.v8.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.RecursiveTask;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.V8File;

@SuppressWarnings("serial")
public class FileReader
    extends RecursiveTask<Boolean>
{
    private V8File file;

    public FileReader( V8File file )
    {
        this.file = file;
    }

    @Override
    protected Boolean compute()
    {
        Boolean allOk = true;
        try (InputStream dataStream = file.getBody().getDataStream();
            OutputStream fos = new BufferedOutputStream( new FileOutputStream( getOrCreateFile( file ) ) ))
        {
            ByteStreams.copy( dataStream, fos );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            allOk = false;
        }
        return allOk;
    }

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
                e.printStackTrace();
            }
        }
        return file;
    }

}

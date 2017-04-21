package com.minimajack.v8.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
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
        File fileReal = null;
        try
        {
            fileReal = getOrCreateFile( file );
            Path p = fileReal.toPath();
            long lastModifyVirtual = file.getAttributes().getModifyDate().getTime();
            long createdVirtual = file.getAttributes().safeGetCreationDate().getTime();

            FileTime attrs = Files.getLastModifiedTime( p, LinkOption.NOFOLLOW_LINKS );
            if ( attrs.toMillis() == lastModifyVirtual )
            {
                return allOk;
            }
            try (InputStream dataStream = file.getBody().getDataStream();
                OutputStream fos = new BufferedOutputStream( new FileOutputStream( fileReal ) ))
            {
                ByteStreams.copy( dataStream, fos );
            }
            catch ( Exception e )
            {
                System.out.println( "creation time " + createdVirtual + "\t modtime: " + lastModifyVirtual );
                allOk = false;
            }
            Files.setAttribute( p, "creationTime", FileTime.fromMillis( createdVirtual ) );
            Files.setAttribute( p, "lastModifiedTime", FileTime.fromMillis( lastModifyVirtual ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            allOk = false;
        }

        return allOk;
    }

    private final File getOrCreateFile( V8File v8File )
        throws IOException
    {
        String name = v8File.getAttributes().getName().trim();
        String path = v8File.getContext().getPath();
        File file = new File( path );
        file.mkdirs();
        file = new File( path + File.separator + name + ".txt" );
        if ( !file.exists() )
        {
            file.createNewFile();
        }
        return file;
    }

}

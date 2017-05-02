package com.minimajack.v8.packer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import com.google.common.io.ByteStreams;
import com.minimajack.v8.format.Container;
import com.minimajack.v8.format.V8File;
import com.minimajack.v8.format.V8FileAttribute;
import com.minimajack.v8.io.metrix.ChunkSizeResolver;
import com.minimajack.v8.io.writer.BlockHeaderChunkWriter;
import com.minimajack.v8.io.writer.ContainerWriter;
import com.minimajack.v8.io.writer.RawChunkWriter;

@Deprecated
public class SimpleFileContainerWriter
    extends ContainerWriter
{

    boolean packed;

    final ConcurrentLinkedDeque<File> aFiles = new ConcurrentLinkedDeque<>();

    public SimpleFileContainerWriter( File path, boolean packed )
    {
        if ( path == null )
        {
            throw new InvalidParameterException( "Path can't be null" );
        }
        int version = 0;
        HashMap<String, File> fileNames = new HashMap<String, File>();
        File[] fileList = path.listFiles();
        if ( fileList == null )
        {
            throw new InvalidParameterException( "Path must be a file" );
        }
        for ( File file : fileList )
        {
            fileNames.put( file.getName().toLowerCase(), file );

        }
        fileNames.keySet().stream().map( n -> {
            if ( n.endsWith( ".txt" ) )
            {
                return n.substring( 0, n.lastIndexOf( '.' ) );
            }
            else
            {
                return n;
            }
        } ).sorted().forEach( t -> {
            if ( fileNames.containsKey( t ) )
            {
                aFiles.add( fileNames.get( t ) );
            }
            else
            {
                aFiles.add( fileNames.get( t + ".txt" ) );
            }
        } );

        this.packed = packed;
        Container container = new Container();
        container.setVersion( version );
        this.setContainer( container );
        this.setFileSystemSize( aFiles.size() * V8File.FILE_DESCRIPTION_SIZE );

    }

    @Override
    public boolean hasData()
    {
        return super.hasData() || aFiles.size() > 0;
    }

    @Override
    public void getDataToWrite()
    {
        File currentFile = aFiles.poll();
        V8File v8file = new V8File();
        Path p = currentFile.toPath();
        long createdVirtual = 0;
        long lastModifyVirtual = 0;
        try
        {
            createdVirtual = ( (FileTime) Files.getAttribute( p, "creationTime" ) ).toMillis();
            lastModifyVirtual = ( (FileTime) Files.getAttribute( p, "lastModifiedTime" ) ).toMillis();
        }

        catch ( IOException e2 )
        {
            e2.printStackTrace();
        }

        V8FileAttribute attributes = new V8FileAttribute();
        attributes.setPosition( this.getPosition() );
        attributes.setName( getRealName( currentFile ) );
        attributes.setCreationDate( new Date( createdVirtual ) );
        attributes.setModifyDate( new Date( lastModifyVirtual ) );
        int attrSize = attributes.getPayloadSize();
        attributes.setDocSize( attrSize );

        BlockHeaderChunkWriter atrChunkWriter = new BlockHeaderChunkWriter( attributes );
        atrChunkWriter.setSizeResolver( new ChunkSizeResolver( attrSize ) );
        atrChunkWriter.setFullSize( attrSize );

        this.attachAdditionData( atrChunkWriter );

        v8file.setAttributes( attributes );

        byte[] data;
        if ( currentFile.isDirectory() )
        {
            SimpleFileContainerWriter fscw = new SimpleFileContainerWriter( currentFile, false );
            fscw.writeAllData();
            data = fscw.getRawData();
            fscw = null;
        }
        else
        {
            data = new byte[(int) currentFile.length()];
            try
            {
                ByteStreams.readFully( new FileInputStream( currentFile ), data );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
        if ( this.packed )
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DeflaterOutputStream dataStream = new DeflaterOutputStream( baos, new Deflater( 6, true ) );
            try
            {
                dataStream.write( data );
                dataStream.finish();
                dataStream.flush();
            }
            catch ( IOException e1 )
            {
                e1.printStackTrace();
            }
            data = baos.toByteArray();
        }

        v8file.setBodyAddress( this.getPosition() );
        RawChunkWriter bodyChunkWriter = new RawChunkWriter( data );
        if ( this.packed )
        {
            bodyChunkWriter.setSizeResolver( new ChunkSizeResolver( Math.max( 512, data.length ) ) );
        }
        else
        {
            bodyChunkWriter.setSizeResolver( new ChunkSizeResolver( data.length ) );
        }

        this.attachAdditionData( bodyChunkWriter );

        try
        {
            this.write( v8file );
        }
        catch ( IOException e )
        {
            throw new RuntimeException( "Cant write v8File" );
        }

    }

    @Override
    public byte[] getRawData()
    {
        return super.getRawData();
    }

    private String getRealName( File file )
    {
        String fileName = file.getName();
        if ( file.isDirectory() )
        {
            return fileName;
        }
        else
        {
            return fileName.substring( 0, fileName.length() - 4 );
        }
    }
}

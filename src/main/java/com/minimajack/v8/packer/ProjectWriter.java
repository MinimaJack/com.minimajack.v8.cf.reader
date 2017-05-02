package com.minimajack.v8.packer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
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
import com.minimajack.v8.project.FileType;
import com.minimajack.v8.project.ProjectTree;

public class ProjectWriter
    extends ContainerWriter
{
    public static final int MIN_PACKED_CHUNK_SIZE = 512;

    private boolean packed;

    final Deque<ProjectTree> aFiles = new LinkedList<ProjectTree>();

    private String location;

    public ProjectWriter( ProjectTree root, boolean packed, String location )
    {
        this.packed = packed;
        this.location = location;
        Container container = new Container();
        container.setVersion( root.child.size() );
        this.setContainer( container );
        this.setFileSystemSize( root.child.size() * V8File.FILE_DESCRIPTION_SIZE );
        for ( ProjectTree file : root.child )
        {
            aFiles.add( file );
        }

    }

    @Override
    public void getDataToWrite()
    {
        ProjectTree currentFile = aFiles.poll();
        V8File v8file = new V8File();
        Path p = Paths.get( location + currentFile.getPath() );
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
        attributes.setName( currentFile.name );
        attributes.setCreationDate( new Date( createdVirtual ) );
        attributes.setModifyDate( new Date( lastModifyVirtual ) );
        int attrSize = attributes.getPayloadSize();
        attributes.setDocSize( attrSize );

        BlockHeaderChunkWriter atrChunkWriter = new BlockHeaderChunkWriter( attributes );
        atrChunkWriter.setSizeResolver( new ChunkSizeResolver( attrSize ) );
        atrChunkWriter.setFullSize( attrSize );

        this.attachAdditionData( atrChunkWriter );

        v8file.setAttributes( attributes );

        byte[] data = null;
        if ( currentFile.type.equals( FileType.CONTAINER ) )
        {
            ProjectWriter fscw = new ProjectWriter( currentFile, false, this.location );
            fscw.writeAllData();
            data = fscw.getRawData();
            fscw = null;
        }
        else
        {
            try (FileInputStream fis = new FileInputStream( new File( location + currentFile.getPath() ) ))
            {
                data = ByteStreams.toByteArray( fis );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }

        if ( this.packed )
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try (DeflaterOutputStream dataStream = new DeflaterOutputStream( baos, new Deflater( 6, true ) );)
            {
                ByteStreams.copy( new ByteArrayInputStream( data ), dataStream );
            }
            catch ( IOException e1 )
            {
                e1.printStackTrace();
            }
            data = baos.toByteArray();
        }
        if ( data == null )
        {
            throw new RuntimeException( "Data can't be null" );
        }
        v8file.setBodyAddress( this.getPosition() );
        RawChunkWriter bodyChunkWriter = new RawChunkWriter( data );
        if ( this.packed )
        {
            bodyChunkWriter.setSizeResolver( new ChunkSizeResolver( Math.max( MIN_PACKED_CHUNK_SIZE, data.length ) ) );
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
    public boolean hasData()
    {
        return super.hasData() || aFiles.size() > 0;
    }

}

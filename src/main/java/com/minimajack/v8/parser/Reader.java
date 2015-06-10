package com.minimajack.v8.parser;

import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import com.minimajack.v8.format.Container;
import com.minimajack.v8.model.ContainerReader;
import com.minimajack.v8.model.Context;
import com.minimajack.v8.model.CountHolder;

public class Reader {

	public Container container;

	public final void unpack(String string, String destination) {
		try (RandomAccessFile aFile = new RandomAccessFile(string, "r");
				FileChannel inChannel = aFile.getChannel();) {
			MappedByteBuffer buffer = inChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			buffer.order(ByteOrder.LITTLE_ENDIAN);

			Context root = new Context();
			root.setName(destination);
			if(!string.endsWith(".hbk")){
				root.setInflated(true);
			}
			root.setReader(ContainerReader.class);

			this.container = new Container(buffer);
			this.container.setContext(root);

			root.parseContainer(container);
			do {
				Thread.sleep(1000);
				System.out.println("Active tasks: " + CountHolder.get());
			} while (CountHolder.get() != 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

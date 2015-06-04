package com.minimajack.v8.parser;

public class MainApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage %file% %path%");
			return;
		}
		Reader reader = new Reader();
		reader.unpack(args[0], args[1]);
	}

}

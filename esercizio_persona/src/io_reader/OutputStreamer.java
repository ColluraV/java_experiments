package io_reader;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamer {


	public static void main(String[] args) throws IOException {
		run();

	}

	private static void run() throws IOException {
		byteXbyte();
		uniqueSolution();
	
	}


	private static void byteXbyte() throws IOException {
		String stringa="zio è chiaro, ggialossai, fresco di zona";
		byte[] b=stringa.getBytes();
		FileOutputStream os1 = new FileOutputStream("test_write.txt",true);
		for (byte c : b) {
			os1.write(c);
		}
	}
	
	private static void uniqueSolution() throws IOException {
		String stringa="zio è chiaro, ggialossai, fresco di zona";
		byte[] b=stringa.getBytes();
		FileOutputStream os1 = new FileOutputStream("test_write.txt",true);
		os1.write(b);
	}

}

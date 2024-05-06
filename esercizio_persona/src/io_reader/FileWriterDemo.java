package io_reader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		run();
	}

	private static void run() throws IOException {
		unbuffered();
		buffered();
	}

	private static void unbuffered() throws IOException {
		FileWriter fW= new FileWriter("test_write.txt",true);

		fW.write("prova non buffered");
		fW.flush();
		fW.close();
	}

	private static void buffered() throws IOException {
		FileWriter fW= new FileWriter("test_write.txt",true);
		BufferedWriter bW = new BufferedWriter(fW);
		bW.newLine();
		bW.write("prova buffered");
		bW.newLine();
		bW.write("capo? funonzica");
		bW.flush();
		bW.close();
	}
	
	


}

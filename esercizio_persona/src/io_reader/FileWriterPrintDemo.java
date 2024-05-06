package io_reader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterPrintDemo {

	public static void main(String[] args) throws FileNotFoundException {
		run();

	}

	
	private static void run() throws FileNotFoundException {
		PrintWriter pw=new PrintWriter("test_write.txt");
		String stringa="tentativo con printWriter";
		pw.print(stringa);
		pw.flush();
		pw.close();
	}

}

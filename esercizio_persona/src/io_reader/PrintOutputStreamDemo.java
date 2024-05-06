package io_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintOutputStreamDemo {

	
	public static void main(String[] args) {
		
		FileOutputStream file=null;
		try {
			file = new FileOutputStream("test_write.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(8);
		}
		run(file);
		

	}

	private static void run(FileOutputStream file) {
		PrintStream output = new PrintStream(file, true);
		if (output.checkError()==true) {
			System.out.println("il file è ok");
		}else {
			System.out.println("non trovo il file");
		}
		output.print("gianni morandi mangia siepe");
		output.close();
	}

}

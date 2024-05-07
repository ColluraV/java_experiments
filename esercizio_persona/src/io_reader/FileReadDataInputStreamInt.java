package io_reader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class FileReadDataInputStreamInt {
	DataInputStream dS;
	int unit;
	public FileReadDataInputStreamInt() throws FileNotFoundException {
		dS=new DataInputStream(new FileInputStream("integer.dat"));
	}

	void dataPrinter() throws IOException{
		while (true) {
			unit=dS.read();
			System.out.println(unit);
		}
	}
}

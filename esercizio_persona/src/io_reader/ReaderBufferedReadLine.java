package io_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderBufferedReadLine {

	public static void main(String[] args) throws IOException {
		run();
		
	}
	

	private static void run() throws IOException {
		FileReader fr= new FileReader("text2.txt");
		BufferedReader br =new BufferedReader(fr);	
		String readedChars;
		StringBuilder sb=new StringBuilder();
		
		while ((readedChars = br.readLine()) != null) {
			System.out.println(readedChars);
		}

	}

}

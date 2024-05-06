package io_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderBufferedReader {

	static final char CR= '\r';
	static final char LF= '\n';
	
	public static void main(String[] args) throws IOException {
		run();
		
	}

	@SuppressWarnings("null")
	private static void run() throws IOException {
		FileReader fr= new FileReader("text2.txt");
		BufferedReader br =new BufferedReader(fr);	
		int readedChar;
		StringBuilder sb=new StringBuilder();
		
		while ((readedChar = br.read()) != -1) {
		    char character = (char) readedChar;
		    System.out.println(character);
		    
		    if(character==CR){

		    }else if(character==LF) {
		    	sb.append(" ");
		    }else
		    sb.append(character);
		}
		String contenuto = sb.toString();
		System.out.println(contenuto);

	}

}

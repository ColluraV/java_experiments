package io_reader;

import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderPolimorfico {
	static final int EOF = -1;
	static final char CR = '\r'; // x'0D' Carriage Return 
	static final char LF = '\n'; // x'0A' Line Feed
	private char[] charArray = {'E', 's', 'e', 'm', 'p', 'i',
						'o'};
	
	public void main(String[] args) throws IOException {
		ReaderPolimorfico rp = new ReaderPolimorfico();
		rp.run();
	
	}
	
	public void run() throws IOException {
		Reader fileReader = new FileReader("text2.txt");
		CharArrayReader cArr= new CharArrayReader(charArray);
		
		stampa(cArr);
		stampa(fileReader);

	}
	
	private void stampa(Reader rd) throws IOException {
		StringBuilder sb= new StringBuilder();
		int charInt=0;
		charInt = rd.read();
		while (charInt!=EOF) {
			System.out.println((char) charInt);
			if (charInt==CR||charInt==LF) {
				charInt=rd.read();
				continue;
			}
			sb.append((char)charInt);
			charInt=rd.read();
			
		}
		System.out.println(sb);
		
	}
}
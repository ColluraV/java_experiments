package io_reader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileWriteDataOutputStreamInt {

	public static void main(String[] args) throws IOException {
		//fileGenerator();
		run();
	}

	private static void run() throws IOException {
		FileReader fr= new FileReader("integer.txt");
		BufferedReader br =new BufferedReader(fr);	
		String readedLine;
		StringBuilder sb=new StringBuilder();
		DataOutputStream out=new DataOutputStream(new FileOutputStream("integer.dat",true));
		
		while ((readedLine = br.readLine()) != null) {
			String[] numbers = readedLine.split("\\s+");
			for (String numberStr : numbers) {
				System.out.println(numberStr);
                int number = Integer.parseInt(numberStr);
				out.writeInt(number);
			}
		}
		out.close();
		br.close();
		
	}

//
//	private static void fileGenerator() {
//		 try {
//	            File file = new File("integer.dat");
//	            if (file.createNewFile()) {
//	                System.out.println("File creato: " + file.getName());
//	            } else {
//	                System.out.println("Il file esiste già.");
//	            }
//	        } catch (IOException e) {
//	            System.out.println("Si è verificato un errore.");
//	            e.printStackTrace();
//	        }
//	    }
//	
}

package esercizi_java_spFormazione;

import java.util.Scanner;

//il programma deve leggere una stringa finchè non si digita stop
public class EsercizioScanner {
	public static void main (String[]args) {
		
		String endWord = "stop";
		String nextWord;
	    System.out.println("Digita una parola");
	    Scanner src = new Scanner (System.in);
	
		while (src.hasNext(endWord)==false) {
			nextWord=src.nextLine();
			System.out.println(nextWord);
				
		}
		System.out.println("hai digitato Stop");
		src.close();
	
	}
}

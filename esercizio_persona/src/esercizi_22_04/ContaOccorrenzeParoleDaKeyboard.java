package esercizi_22_04;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class ContaOccorrenzeParoleDaKeyboard {
	/*
	 * 1 chiedere in console una stringa con n parole separate da spazio 2
	 * utilizzare lo scanner(system.in) e sc.nextline() 3 trattare la stringa
	 * ricevuta (scanner) diparole separate da uno o più spazi 4 stampare le parole
	 * digitate utilizzando StringBuilder per comporla 5 stampare ilnumero di
	 * occorrenze di ogni parola utilizzo di Map(HashMap) e EntrySet
	 * es=map.entrySet() e forEach su es 6 stampare la parola con più occorrenze
	 * (solo la prima)
	 * 
	 */

	public static void main(String[] args) {
		ContaOccorrenzeParoleDaKeyboard count = new ContaOccorrenzeParoleDaKeyboard();																						
		count.run();

	}

	private void run() {

		Map<String, Integer> occorrenze = new HashMap<>();

		Integer numOc;

		Scanner src = new Scanner(System.in);
		String line = new String();
		String wordMax = "";
		Integer wordMaxValue = 0;

		System.out.println("Digita delle parole separate da spazio");
		line = src.nextLine();
		Scanner srcWords = new Scanner(line);


		while (srcWords.hasNext()) {
			String word = (String) srcWords.next();
			numOc = occorrenze.get(word);
			if (numOc == null) {
				occorrenze.put(word, 1);
			} else {
				occorrenze.put(word, ++numOc);
			}
		}
		for (Entry<String, Integer> keyValue : occorrenze.entrySet()) {
			if (keyValue.getValue() > wordMaxValue) {
				wordMaxValue = keyValue.getValue();
				wordMax = keyValue.getKey();
			}
		}
		System.out.println("La parola più utilizzata è");
		System.out.println(wordMax);
		System.out.println(wordMaxValue + " volte");

	}

}

package esercizio_ReadAndSort;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndSort {
	String fileName;
	Set<String> set;
	String word;
	Scanner src;
	Set<String> orderedWords;
	List<String> list;
	File file;
	StringBuilder strBuild;

	/*
	 * Leggere un file di testo es(parola1, parola2, parola3ecc..) restituire una
	 * stringa senza duplicati in ordine inverso alfabetico separate da uno spazio
	 */
	public ReadAndSort() {
		this.fileName = "fileReadAndSort.txt";
	}

	public static void main(String[] args) {
		ReadAndSort readAndSort = new ReadAndSort();
		// TODO Auto-generated method stub
		try {
			readAndSort.run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	StringBuilder run() throws FileNotFoundException {
		// carico file
//		list = new ArrayList<>(); 
		file = new File(fileName);
		src = new Scanner(file);
		orderedWords = new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
		ListFiller();
		return ListOrder();

	}

	private StringBuilder ListOrder() {
		strBuild = new StringBuilder();

//		//ordino lista e genero un set
//		list.sort( (o1, o2) -> o2.compareTo(o1));
//		set = new LinkedHashSet<String>(list);
//		System.out.println(set.toString());
//		questo metodo è superfluo

		for (String string : orderedWords) {
			strBuild.append(string + " ");
		}
		System.out.println(strBuild);
		return strBuild;
	}

	private void ListFiller() {
		// genero treeset
		while (src.hasNext()) {
			word = (String) src.next();
			orderedWords.add(word);
		}

		System.out.println(orderedWords);
	}

}

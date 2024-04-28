package esercizi_java_spFormazione;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import esempiVari.scanner.ScanFileNamesRefactored;

/*leggere da keboard n° elementi array di int
 * 
 * leggere tipo ordinamento A/O
 * 
 * istanziare Array
 * 
 * stamparlo ordinato
 * 
 * 
 */

public class esercizio_16_04 {

	public static void main(String[] args) {

		// istanzio lo scanner
		Scanner scn = new Scanner(System.in);

		// chiedo la dimensione dell'array
		System.out.print("Inserisci il numero di elementi dell'array: ");

		int arrLenght = scn.nextInt();

		// chiedo la preferenza di ordinamento
		System.out.print("Vuoi ordinare in modo ascendente (A) o discendente (O)? ");
		char choice = scn.next().charAt(0);

		System.out.println("Inserisci dei numeri");

		// Istanziazione dell'array
		Integer[] arr = new Integer[arrLenght];

		// Inizializzazione dell'array
		System.out.println("Inserisci gli elementi dell'array:");
		for (int i = 0; i < arrLenght; i++) {
			arr[i] = scn.nextInt();
		}

		if (choice == 'A') {

			Arrays.sort(arr);
		} else {
			Arrays.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {

					return o2.compareTo(o1);
				}
			});
		}
		for (Integer integer : arr) {
			System.out.println(integer);
			
		
		}
	}
}
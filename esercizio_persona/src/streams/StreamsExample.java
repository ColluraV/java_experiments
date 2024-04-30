package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsExample {
	
	
	public static void main(String[] args) {
	// Creazione di uno Stream da un array
	String[] coloriArray = new String[] {"bianco", "rosso", "giallo", "blu", "verde"};
	Stream<String> streamDaArray = Arrays.stream(coloriArray);

	// Creazione di uno Stream da una lista di elementi
	Stream<String> streamDaElementi = Stream.of("bianco", "rosso", "giallo", "blu", "verde");

	// Creazione di uno Stream da una Collection
	Collection<String> coloriList = Arrays.asList(coloriArray);
	Stream<String> streamDaCollection = coloriList.stream();
	
	// Filtraggio di uno Stream per selezionare solo gli elementi pari
	List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6);
	Stream<Integer> numeriPari = numeri.stream().filter(n -> n % 2 == 0);

	// Mappatura di uno Stream per trasformare ogni elemento
	List<String> nomi = Arrays.asList("Alice", "Bob", "Charlie");
	Stream<Integer> lunghezzeNomi = nomi.stream().map(String::length);

	// Raccolta degli elementi di uno Stream in una lista
	List<Integer> numeriPariList = numeriPari.collect(Collectors.toList());

	// Generazione di uno Stream di numeri casuali
	Stream<Double> streamRandom = Stream.generate(Math::random).limit(10);
	
	// Utilizzo di forEach per iterare sugli elementi di uno Stream
	streamDaArray.forEach(System.out::println);
	
	// Creazione di uno Stream di numeri pari infinito, limitato ai primi 10 elementi
	Stream<Integer> streamNumeriPari = Stream.iterate(2, n -> n + 2).limit(10);

	/* STREAM PIPELINES*/
		/*FILTRAGGIO E CONTEGGIO*/
		List<String> parole = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
		long conteggio = parole.stream() // Crea uno stream dalla lista
		    .filter(s -> s.startsWith("b")) // Operazione intermedia per filtrare le parole che iniziano con "b"
		    .count(); // Operazione terminale per contare gli elementi
		System.out.println(conteggio); // Output: 1

		/*MAPPATURA E RACCOLTA*/
		List<String> frutti = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
		List<String> fruttiMaiuscoli = frutti.stream() // Crea uno stream dalla lista
		    .map(String::toUpperCase) // Operazione intermedia per convertire ogni elemento in maiuscolo
		    .collect(Collectors.toList()); // Operazione terminale per raccogliere i risultati in una lista
		System.out.println(fruttiMaiuscoli); // Output: [APPLE, BANANA, CHERRY, DATE, FIG, GRAPE]
		
		/*COMBINAZIONE*/
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
		String risultato = names.stream() // Crea uno stream dalla lista
		    .filter(s -> s.length() > 3) // Filtra i nomi con più di 3 lettere
		    .map(String::toUpperCase) // Converte i nomi rimanenti in maiuscolo
		    .sorted() // Ordina i nomi
		    .collect(Collectors.joining(", ")); // Li unisce in una stringa separata da virgole
		System.out.println(risultato); // Output: ALICE, CHARLIE, DAVID

	}

}


package streams;

/*
 * Creazione List
 * Creazione Stream da List
 * Filter su Stream con Predicato (classe anonima)
 * Filter su Stream con Predicato (lambda expression)
 * Stampa Stream con lambda esplicito
 * Stampa Stream con lambda conciso
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamPredicateDemo {

	public static void main(String[] args) {

		String [] arr = {"a", "b", "c"};
		Stream<String> StreamOfArrayPart = Arrays.stream(arr, 0, 2);
		StreamOfArrayPart.forEach((o) -> System.out.println(o));
		
		//1 Creazione stream da List
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(401);
		list4.add(403);
		list4.add(1, 402);
		list4.add(404);
		list4.add(400);
		System.out.println(list4);
		
		//2 Creazione Stream da collection
		Stream<Integer> stream = list4.stream();
		Stream<Integer> stream2 = list4.stream();
				
		//3 Creazione Stream filtrata con classica classe anonima
		Stream<Integer> filteredStream = stream.filter(new Predicate<Integer>() {
		    @Override
		    public boolean test(Integer item) {
		        return item > 401;
		    }
		});
		 		
		//4 Creazione Stream filtrata con notazione lambda compatta
		Stream<Integer> filteredStream2 = stream2.filter(s -> s > 401);
		 		
 		//5 Stampa oggetti Stream lambda esplicito 
  		filteredStream.forEach((s) -> System.out.println(s));

 		//6 Stampa oggetti Stream lambda esplicito 
  		filteredStream2.forEach((s) -> System.out.println(s));

		//7 Stampa oggetti Stream lambda semplificato 
 		filteredStream.forEach(System.out::println);
	}

}

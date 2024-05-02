package streams;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String[] args) throws IOException {
		StreamDemo S = new StreamDemo();
		S.run();
	}

	public void run() throws IOException{
	    
        List<String> lsAsList = Arrays.asList("F", "b", "C", "dFIELD", "E", "A");
        List<String> lsAsListDup = Arrays.asList("A", "A", "B", "C", "B", "A");
        List lsOf = List.of("A", "B", "C", "D", "e", "F");  // Immutable
        List<Integer> lsInt = Arrays.asList(3, 4, 345, 22, 18);
        List<String> listFromStream = null;
        String str = "";
        long count = 0;
        
        System.out.println(lsAsList);
	    System.out.println(lsOf);
//	    String str = "I\n am\n the\n creator of this Blog";
//	    System.out.println(str.lines().collect(Collectors.toList()));

	    //1 Stream verbose con Predicate
	    System.out.println();
	    System.out.println("1 Stream verbose con Predicate");
	    lsAsList.stream()
	             .filter(new Predicate<String>() {
					@Override
					public boolean test(String t) {
						return t.length() < 4 ? true : false;
					    }
				     })			      
				 .map((s) -> s.toUpperCase())
				 .sorted()
				 .forEach((s) -> System.out.println(s));

	    //2 Stream con Lambda compatto esteso
	    System.out.println();
	    System.out.println("2 Stream con Lambda ultra compatto");
	    lsAsList.stream()
	             .filter(name -> name.length() < 4)			      
				 .map(s -> s.toUpperCase())
				 .sorted()
				 .forEach((s) -> System.out.println(s));
	    
	    //3 Stream con Lambda compatto
	    System.out.println();
	    System.out.println("3 Stream con Lambda compatto");
	    lsAsList.stream()
	             .filter((name) -> name.length() < 4)			      
				 .map((s) -> s.toUpperCase())
				 .sorted()
				 .forEach((s) -> System.out.println(s));	
	    	    
	    //4 Stream con Lambda ultra compatto
	    System.out.println();
	    System.out.println("4 Stream con Lambda ultra compatto");
	    lsAsList.stream()
	             .filter(name -> name.startsWith("d"))			      
				 .map(String::toUpperCase)
				 .sorted()
				 .forEach(System.out::println);	
	       
	    //5 Stream con sort descending e comparatore embedded
	    System.out.println();
	    System.out.println("5 Stream con sort descending e comparatore embedded");
	    lsAsList.stream()
	             .filter(name -> name.length() < 4)			      
				 .map(String::toUpperCase)
				 .sorted(new Comparator<String>() {
					  @Override
					  public int compare(String o1, String o2) {
						  return o2.compareTo(o1);
					  }
				     })
				 .forEach(System.out::println);	
	       
	    //6 Stream con sort descending e comparatore con Lambda
	    System.out.println();
	    System.out.println("6 Stream con sort descending e comparatore con Lambda");
	    lsAsList.stream()
	             .filter(name -> name.length() < 4)			      
				 .map(String::toUpperCase)
 				 .sorted((o1,o2) -> o2.compareTo(o1))
// 				 .sorted(Comparator.reverseOrder())
				 .forEach(System.out::println);	
	       
	    //7 Stream per count 
	    System.out.println();
	    System.out.println("7 Stream con count ");
	    count = lsAsList.stream()
	                    .filter(name -> name.length() < 4)			      
		 		        .count();
	    System.out.println("Count=" + count + " con length() < 4 ");  
	       
	    //8 Stream per Optional max ultracompatto 
	    System.out.println();
	    System.out.println("8 Stream per Optional max ultracompatto ");
	    Optional<Integer> max7 = lsInt.stream().max(Integer::compareTo);		 		                       
	    if (max7.isPresent()) {
	    	System.out.println("Max=" + max7);  
		}else {
			 System.out.println("Max=Non Presente");
		}
	
	    //9 Stream per Optional max ultracompatto 
	    System.out.println();
	    System.out.println("8 Stream per max senza optional con get ultracompatto");
	    Integer max8 = lsInt.stream().max(Integer::compareTo).get();		 		                       
	    System.out.println("Max=" + max8);  
	    
	    //10 Stream per min ultracompatto
	    System.out.println();
	    System.out.println("9 Stream per max ultracompatto");
	    Optional<Integer> min7 = lsInt.stream() 
	    		                      .min(Integer::compareTo);		 		                       
	    System.out.println("Min=" + min7);  
	    
	    //11 Stream con rimozione duplicati
	    System.out.println("11 Stream con rimozione duplicati");
	    lsAsListDup.stream()
	               .distinct()			      
				   .forEach(System.out::println);	
	      
	    //12 Stream per limitare i risultati
	    System.out.println();
	    System.out.println("12 Stream per limitare i risultati");
	    lsAsList.stream()
	            .limit(2)
	            .forEach(System.out::println);	
	    
	    //13 Stream per estrazione Chars da String
	    System.out.println();
	    System.out.println("13 Stream per estrazione Chars da String");
	    str = "Questo è un corso di Java";
	    str.chars().forEach(o->System.out.println(o));
	    
	    //14 Stream per estrazione linee da String
	    System.out.println();
	    System.out.println("14 Stream per estrazione linee da String");
	    str = "Questo\n e\n un\n corso di Java";
	    listFromStream = str.lines()
	    		            .collect(Collectors.toList());
	    System.out.println(listFromStream);
		 				
	    //15 Estrazione lines con split (meno efficiente)
	    System.out.println();
	    System.out.println("15 Estrazione lines con split (meno efficiente");
	    String[] ArrayFromString = str.split("\\n");
	    System.out.println(ArrayFromString.toString());                // Non stampa gli elementi ma solo address object
	    
	    //16 Stream per concatenamento elementi con collect(Collectors..)
	    System.out.println();
	    System.out.println("16 Stream per concatenamento elementi con collect(Collectors..)");
	    Stream<String> sl = lsAsList.stream();
	    String sConcat = sl.collect(Collectors.joining("|"));
	    System.out.println("Elementi concatenati="+sConcat);                // Non stampa gli elementi ma solo address object
	 
	    //17 Stream per riduzione elementare e concatenamento elementi compatto
	    System.out.println();
	    System.out.println("17 Stream per riduzione elementare e concatenamento elementi compatto");
	    Stream<String> sl2 = lsAsList.stream();
	 	String sConcat2 = sl2.reduce(" ", String::concat);
	    System.out.println("Elementi concatenati="+sConcat2);                // Non stampa gli elementi ma solo address object
	    
	    //18 Stream per grouping generazione Map con counters
	    System.out.println();
	    System.out.println("18 Stream per grouping generazione Map con counters");
       	List<String> lsGroup = Arrays.asList("Mauri", "Alberto", "Mauri", "Carlo", "Mauri", "Giusi");  
  	    Map<String, Long> map =
              lsGroup.stream()
    		         .collect(Collectors.groupingBy(
                             Function.identity(), Collectors.counting()
                             )
  	    );
  	    System.out.println(map);

	    //19 Stream per somma con  Collectors.summingDouble	    
	    System.out.println();
	    System.out.println("19 Stream per somma con  Collectors.summingDouble");
        double totalPrice = lsInt.stream()  
                                 .collect(Collectors.summingDouble(o->o));  
 	    System.out.println(lsInt.toString());
 	    System.out.println("totalPrice="+totalPrice);
 	     	    
	    //20 Stream per Max/Min/Avg/Cnt value in Stream
	    System.out.println();
	    System.out.println("20 Stream per Max/Min/Count value in Stream");
	    List<Integer> listInt = Arrays.asList(-9, -18, 0, 25, 4);
  	    int max = listInt.stream().max(Integer::compare).get();
  	    double cnt = listInt.stream().count();
        Optional<Integer> min = listInt.stream().min((o1, o2) -> Integer.compare(o1, o2));
        Optional<Integer> min2 = listInt.stream().min(Integer::compare);
        System.out.print(min.isPresent() ? "Min:"+min+"\n" : "Non Presente"); 
        System.out.print("Max: "+max); 
        System.out.print("Count: "+cnt); 
       
	    //21 Stream per calcolo con IntSummaryStatistics Average/Max/Min/Sum/Count 
	    System.out.println();
	    System.out.println("21 Stream per grouping generazione Map con counters");
		IntSummaryStatistics iss = listInt.stream()
				                          .mapToInt(a -> a * 2)
				                          .summaryStatistics(); 
        double avg = iss.getAverage();
        double max1 = iss.getMax();
        double min3 = iss.getMin();
        double count1 = iss.getCount();
        double sum = iss.getSum();
        System.out.println("Max  ="+max1);
        System.out.println("Min  ="+min3);
        System.out.println("Avg  ="+avg);
        System.out.println("Sum  ="+avg);
        System.out.println("Count="+sum);
        System.out.println(iss.toString());
                     	     	    
	    // Collect e Collectors per raggruppare e fare operazioni di gruppo
		List<Student> list = new ArrayList<Student>();		
		// Adding Students
		list.add(new Student(1, "Zedda", 25));
		list.add(new Student(3, "Fadda", 24));
		list.add(new Student(2, "Alberti", 25));
		list.add(new Student(6, "ZAI", 24));
		list.add(new Student(7, "MAHESH", 26));
		list.add(new Student(12, "ROXY", 25));

	    //22 Stream da List con estrazione e produzione List
	    System.out.println();
		System.out.println("22 Stream per estrazione e produzione List");
		List<String> names = list
				      .stream()
				      .map(n -> n.name)
				      .collect(Collectors.toList());
		System.out.println(names);
  	    	
	    //23 Stream conversione List in Map
	    System.out.println();
		System.out.println("23 Stream conversione List in Map");
		record Product(int id, String name, float price) {};
	    List<Product> productsList = new ArrayList<Product>(); 
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  				
        // Conversione Product List in Map  
        Map<Integer,String> productPriceMap =   
            productsList.stream()  
                        .collect(Collectors.toMap(p->p.id, p->p.name));    	
        System.out.println(productPriceMap);  	

	    //24 Stream conversione List in Set
	    System.out.println();
		System.out.println("24 Stream conversione List in Map");
        productsList = new ArrayList<Product>();         
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // Conversione product List in Set  
        Set<Float> productPriceSet = productsList.stream()               
	            .filter(product->product.price < 30000) // filter product on the base of price  
	            .map(product->product.price)  
	            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
        System.out.println(productsList);         
        System.out.println(productPriceSet);         
                
	    //25 Stream Conteggio numeri di prodotti basati su filter
	    System.out.println();
		System.out.println("25 Stream Conteggio numeri di prodotti basati su filter");
        long count21 = productsList.stream()  
                .filter(product->product.price<30000)  
                .count();  
        System.out.println("Count="+count21);  		
		
		
	    //26 Riduzione 6 (1 + 2 + 3)
	    System.out.println();
		System.out.println("26 Riduzione 6 (1 + 2 + 3)");
        OptionalInt reduced = IntStream.range(1,4).reduce((a, b) -> a + b);
        System.out.println("Reduced="+reduced);  		

	    //27 Riduzione = 16 (10 + 1 + 2 + 3)
	    System.out.println();
		System.out.println("27 Riduzione 16 (10 + 1 + 2 + 3)");
        int reducedTwoParams = IntStream.range(1,4).reduce(10, (a, b) -> a + b);
        System.out.println("ReducedTwoParams="+reducedTwoParams);  		
   
        
	    //28 Riduzione = 16 (10 + 1 + 2 + 3) combiner NON richiamato
	    System.out.println();
		System.out.println("28 Riduzione 16 (10 + 1 + 2 + 3) combiner NON richiamato");
        int reducedParams = Stream.of(1, 2, 3) 
        	                  .reduce(10, (a, b) -> a + b, (a, b) -> {
        	                	    System.out.println("combiner was not called"); 
        	                        return a + b;          
        	                      });
        System.out.println("ReducedParams="+reducedParams);  		
       
	    //29 Riduzione = (12 + 13 = 25; 25 + 11 = 36) combiner richiamato
	    System.out.println();
		System.out.println("29 Riduzione(10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;) combiner richiamato");
		System.out.println("            (12 + 13 = 25; 25 + 11 = 36) combiner richiamato");
        int reducedParallel = Arrays.asList(1,2,3).parallelStream()                   
        		                  .reduce(10, (a, b) -> a + b, (a, b) -> { 
        		                	 System.out.println("combiner was called"); 
        		                     return a + b; 
        		                   });
        System.out.println("ReducedParallel="+reducedParallel);  		
 
	    //30 flatMap da file con estrazione parole
	    System.out.println();
		System.out.println("30 flatMap da file con estrazione parole");
		File f = new File("parolestream.txt");
		Path path = f.toPath();
		Files.lines(path, StandardCharsets.UTF_8)
				   .flatMap(line -> Stream.of(line.split(" +")))
				   .filter(s -> !s.isEmpty())
				   .map((s) -> s.toUpperCase())
				   .sorted()
		           .forEach((s) -> System.out.println(s));
        
	    //31 flatMap da file con estrazione parole e produzione List
	    System.out.println();
		System.out.println("30 flatMap da file con estrazione parole");
		File f2 = new File("parolestream.txt");
		Path path2 = f2.toPath();
		List<String> lsWord = Files.lines(path2, StandardCharsets.UTF_8)
				   .flatMap(line -> Stream.of(line.split(" +")))
				   .filter(s -> !s.isEmpty())
				   .map((s) -> s.toUpperCase())
				   .sorted()
		           .collect(Collectors.toList());
        
		
		//14 Arrays parallel sorting 
		System.out.println("\n//14=============================");					
		//Creating an integer array   
        int[] arr = {15,81,11,20,6,19};  
        //Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
        //Parallel sorting   
        Arrays.parallelSort(arr);  
        System.out.println("\nArray elements after sorting");  
        //Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        } 
        
		//15 Arrays parallel sorting from index to index
		System.out.println("\n//15=============================");					
        //Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
        //Parallel sorting with start, end index 
        Arrays.parallelSort(arr,0,3);   
        System.out.println("\nArray elements after sorting");  
        //Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }      
   
	    //12 da Java 11 \n implicito a fine riga
		System.out.println("\n//4=============================");
	    String tb = """    
	    		Hello                
	    		World
	    		""";
	    String tb2 = "Hello\nWorld\n";              
	    System.out.println(tb);
	    		

	}  
			
}

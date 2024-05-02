package streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	int rollNo;
	String name;
	int age;

	public Student(int rollNo, String name, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + "]";
	}
}
 
public class StreamGalleryDemo {
	
	public static void main(String[] args) {
		StreamGalleryDemo S = new StreamGalleryDemo();
		S.run();
	}

	public void run(){
	    
	    //1 \n esplicito, estrazione lines con Stream e trasformazione in una List
		System.out.println("\n//1=============================");
	    String str = "I\n am\n the\n creator of this Blog";
	    List<String> listFromStream = str.lines()
	    		                         .collect(Collectors.toList());
	    System.out.println(listFromStream);

	    //2 \n esplicito, estrazione lines con split (meno efficiente)
		System.out.println("\n//2=============================");
	    String str2 = "I\n am\n the\n creator of this Blog";
	    String[] ArrayFromString = str2.split("\\S + ");  
	    listFromStream = Arrays.asList(ArrayFromString);
	    System.out.println(ArrayFromString.toString());                // Non stampa gli elementi ma solo address object
	    
	    //3 Stampa con iterable da string, array
		System.out.println("\n//3=============================");
	    Arrays.asList(str2).forEach(System.out::println);              // Estraggo iterabile e per ogni elemento stampo con Lambda semplificato 
	    Arrays.asList(ArrayFromString).forEach(System.out::println);   // Estraggo iterabile e per ogni elemento stampo con Lambda semplificato 
	    Arrays.asList(str2).forEach((s)->System.out.println(s));       // Estraggo iterabile e per ogni elemento stampo con Lambda esplicito 
	    
	    //4 Since Java 11 \n implicito a fine riga
		System.out.println("\n//4=============================");
	    String tb = """    
	    		Hello                
	    		World
	    		""";
	    System.out.println(tb);
	    		
	    //5 Stream da List, con filtro, UpperCase, sort e stampa compatta
		System.out.println("\n//5=============================");
	    List<String> listx = Arrays.asList("franz", "ferdinand", "fiel", "vom", "pferd");
	    listx.stream()                               // Restituisce Stream dalla List
	         .filter(name -> name.startsWith("f"))   // Restituisce Stream con match del predicato
	         .map(String::toUpperCase)               // Restituisce Stream con funzione applicata
	         .sorted()                               // Restituisce Stream con elementi ordinati naturalmente
	         .forEach(System.out::println);          // Esegue azione per ogni elemento dello stream
	
	    //6 Stream count with Lambda expression
		System.out.println("\n//6=============================");
	  	List<String> names1 = new ArrayList<String>();
    	names1.add("Jai");
    	names1.add("Mahesh");
    	names1.add("Ajay");
    	names1.add("Hemant");
    	names1.add("Vishal");
    	//Using Stream and Lambda expression
    	long count = names1.stream()
    			           .filter(s->s.length()<5)
    			           .count();
        System.out.println(count+" strings with length less than 5");
 
	    //7 Stream Distinct to remove duplicates creato con classe Stream
		System.out.println("\n//7=============================");
      	Stream.of("Jai", "Mahesh", "Vishal", "Naren", "Hemant", "Naren", "Vishal")
              .distinct()
              .forEach(System.out::println);

	    //8 Stream map to per modificare ogni elemento dello stream
		System.out.println("\n//8=============================");
     	List<String> names2 = Arrays.asList("Jai", "Mahesh", "Vishal", "Hemant", "Naren");
        names2.stream()
              .map(String::toUpperCase)
              .forEach(System.out::println);
        
	    //9 Stream Sorted per sortare gli elementi dello stream
		System.out.println("\n//9=============================");
      	Stream.of("Jai", "Mahesh", "Vishal", "Naren", "Hemant")
    	      .sorted()
              .forEach(System.out::println);
 

	    //10 Stream Collect e Collectors per raggruppare e fare operazioni di gruppo
		System.out.println("\n//10=============================");
       	List<String> names3 = Arrays.asList("Jai", "Naren", "Nidhi", "Nidhi", "Naren", "Nidhi");  
  	    Map<String, Long> map = names3.stream()
  	    		                      .collect(
  	                                        Collectors.groupingBy(
  	                                           Function.identity(), Collectors.counting()
  	                                        )
  	    );
  	    System.out.println(map);
 
  	     	    
	    //11 Stream Collect e Collectors per raggruppare e fare operazioni di gruppo
		System.out.println("\\n//11=============================");
		List<Student> list = new ArrayList<Student>();
		
		// Adding Students
		list.add(new Student(1, "Nidhi", 25));
		list.add(new Student(3, "Parbhjot", 24));
		list.add(new Student(2, "Amani", 25));
		list.add(new Student(6, "Jai", 24));
		list.add(new Student(7, "Mahesh", 26));
		list.add(new Student(12, "Roxy", 25));

		//12 Stream map+Collect Fetching student names as List
		System.out.println("\n//12=============================");
		List<String> names = list.stream()
				                 .map(n -> n.name)
				                 .collect(Collectors.toList());
		System.out.println(names);
  	    			
		//13 Stream Filter as  
		System.out.println("\n//13=============================");
		// Fetching student data as a Set
		Set<Student> students = list.stream()
				                    .filter(n -> n.rollNo > 2)
				                    .collect(Collectors.toSet());
		// Iterating Set
		for (Student stu : students) {
			System.out.println(stu.rollNo + " " + stu.name + " " + stu.age);
		}
	
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
        
	}  
			
}

package esempiVari.scanner;
/*
 * Ing. Giampietro Zedda 2023
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;


public class CollectionsGallery {

	public CollectionsGallery() {
 	}

	public static void main(String[] args) {
				
		//From a list Immutable
		List<Integer> list = List.of(88,15,20,24, 10);      
		System.out.println("Immutable list");
		System.out.println(list);
							
		//From an embedded list
		List<Integer> list2 = Arrays.asList(100,150,200,240);
		System.out.println("From embedded list");
		System.out.println(list2);
				
		//From ArrayList
		List<Integer> list4 = new ArrayList<>();
		list4.add(401);
		list4.add(403);
		list4.add(1, 402);
		list4.add(404);
		list4.add(400);
		list4.add(401);
		System.out.println("Print ArrayList with toString");
		System.out.println(list4);
									
		// Sort
		Collections.sort(list4);
		System.out.println("Print ArrayList sortata con Collections");
		System.out.println(list4);
		
		//Print with forEach
		System.out.println("Print with forEach");
		for (Integer i : list4) {
			System.out.println(i);
		}
 		//Print with forEach lambda
		list4.forEach((s)-> System.out.println(s));
		
		//Print with forEach lambda semplificato
		list4.forEach(System.out::println);
 	
		//Print with Iterator
		System.out.println("Print with Iterator");
		for (Iterator<Integer>  iterator = list4.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			System.out.println(i);
		}

		//Print with Iterator & remove
		System.out.println("Print with Iterator");
		for (Iterator<Integer> iterator = list4.iterator(); iterator.hasNext();) {
			Integer i = (Integer) iterator.next();
			if (i == 400) {
				iterator.remove();
			} else {
				System.out.println(i);
			}			
		}

		//Print with forEach Dopo remove 400
		System.out.println("Print with forEach after remove 400");
		for (Integer i : list4) {
			System.out.println(i);
		}
		
		//Print with for loop
		System.out.println("Print with loop");
		for (int j = 0; j < list4.size(); j++) {
			Integer v = list4.get(j);
			System.out.println(v);
		}
		
        //Sort con comparator esterno (classico ma definito in questa classe)
		list4.sort(new ArrayComparator() );
		System.out.println("Sort con comparator esterno");
		System.out.println(list4);

		list4.add(100);
		System.out.println("Add 100");
		System.out.println(list4);	


        //Sort con comparator embedded (classe anonima)
		list4.sort(
					// Classe anonima
					new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return o1.compareTo(o2);
						}
					}
				); 
		
		System.out.println("Sort con comparator in classe anonima");
		System.out.println(list4);

        //Sort con comparator in classe che implementa Comparator	
		list4.sort(new ArrayComparator());  
		System.out.println("Sort con comparator in classe esterna");
		System.out.println(list4);
		
	    //Sort con comparator con Lambda expression
		list4.sort((o1, o2) -> o2.compareTo(o1));
		System.out.println("Sort con comparator con Lambda expression");
		System.out.println(list4);

	    //Sort con comparator (con Lambda expression compatto) 
		list4.sort(Integer::compare);
		System.out.println("Sort con comparator con Lambda expression compatto");
		System.out.println(list4);
		
		//Inserimento bulk 
		System.out.println("Inserimento Bulk di una collection in un'altra");
		List<Integer> listAddAll1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List<Integer> listAddAll2 = Arrays.asList(5,6,7,8);
		listAddAll1.addAll(listAddAll2);
		System.out.println(listAddAll1);
		
		//////////////////////////////////////
		// LinkedList
		//////////////////////////////////////
		
		List<String> list43 = new LinkedList<String>();
		list43.add("Riga 1");
		list43.add("Riga 2");
		list43.add(1, "Riga 11");
		list43.add("Riga List 3");
		list43.add("Riga List 3");
 		list43.sort( (o1, o2) -> o1.compareTo(o2));
		System.out.println("Sort con comparator in lambda");
		System.out.println(list43);

		
		//From LinkedList
		List<String> list44 = new LinkedList<String>();
		list44.add("Riga 1");
		list44.add("Riga 2");
		list44.add(1, "Riga 11");
		list44.add("Riga List 3");
		list44.add("Riga List 3");
		System.out.println("Print LinkedList toString");
		System.out.println(list44);
		
		//Set 
		Collection<String> set = new HashSet<String>();
		set.add("Stringa 1");
		set.add("Stringa 3");
		set.add("Stringa 3");
		set.add("Stringa 2");
		
		System.out.println("Set HashSet");
		System.out.println(set);

		//Set con input da collection
		System.out.println(list4);
		Set<Integer> set2 = new HashSet<Integer>(list4);
		System.out.println("Set con 401 non duplicato");
		System.out.println(set2);

		//Set ordinato
		list4.add(1, 55555);
		Set<Integer> set3 = new TreeSet<Integer>(list4);
		System.out.println("Set ordinato");
		System.out.println(set3);
		
		//LinkedHashSet
		Set<Integer> setLink = new LinkedHashSet<Integer>();
		setLink.add(23);
		setLink.add(40);
		setLink.add(10);
		System.out.println("Linked Hash set");
		System.out.println(setLink);
		
		//Map
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("m1k1", "V1");
		m1.put("m1k2", "V2");
		m1.put("m1k3", "V3");
		m1.put("m1k4", "V4");
	    if (m1.containsKey("m1k3")) {
			m1.remove("m1k3");
			System.out.println("m1k3 rimosso");
		}
	    if (!m1.containsKey("m1k3")) {
	    	System.out.println("m1k3 era gia rimosso");			
		}
	    if (m1.get("m1k9") == null) {
			System.out.println("m1k9 inesistente");
			m1.put("m1k9", "V9");
			System.out.println("m1k9 inserito");
		}
		System.out.println("HashMap");
		System.out.println(m1);
		
		
		// Map keys
		System.out.println("HashMap keys");
		Set<String> msetk = m1.keySet();
		for (String k : msetk) {
			String v1 = m1.get(k);
			System.out.println(k+" - "+v1);
		}

		//Map values
 		System.out.println("HashMap values");
  		for (String v : m1.values()) {
 			System.out.println(v);
 		}
		
		// Map entries
		Set<Entry<String, String>> msetEntry = m1.entrySet();
		for (Entry<String, String> entry : msetEntry) {
			String k1 = entry.getKey();
			String v2 = entry.getValue();
			System.out.println("EntrySet "+k1+ " "+v2);
		}
		
		Properties p = System.getProperties();
		System.out.println("Properties di sistema");
		System.out.println(p.toString());
		
		Set<Entry<Object, Object>> es = p.entrySet();
		for (Entry<Object, Object> entry : es) {
			System.out.println(entry.getKey() + " - "+ entry.getValue());
		}
		
//		int[] arInt = new int[4];
//		Arrays.sort(arInt, new Comparator() {});
	}
	
	// inner static Class 2
    // Helper class implementing Comparator interface
    static class ArrayComparator
       implements Comparator<Integer> {
 
 		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
    }
 
}

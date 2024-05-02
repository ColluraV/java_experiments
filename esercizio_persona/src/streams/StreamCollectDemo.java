package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectDemo {

	public static void main(String[] args) {
		StreamCollectDemo x = new StreamCollectDemo();
        x.run();
	}

	private void run() {
		
		// Creazione List di prodotti
		List<Product> productList = Arrays.asList(
				  new Product(23, "potatoes"),
				  new Product(14, "orange"), 
				  new Product(13, "lemon"),
				  new Product(23, "bread"), 
				  new Product(13, "sugar"));
 	    
		// Riduzione a List<String>
		// Conversione stream in una Collection (Collection, List or Set)
		// estraendo il solo name
		List<String> collectorCollection = 
	    productList.stream()
	               .map(Product::getName)
	               .collect(Collectors.toList());

		// Riduzione a String
		String listToString = productList
				            .stream()
				            .map(Product::getName)
				            .collect(Collectors.joining(", ", "[", "]"));
		
		// Processing the average value of all numeric elements of the stream:
		double averagePrice = productList.stream()
				               .collect(Collectors.averagingInt(Product::getPrice));
	
		// Processing the sum of all numeric elements of the stream:
		int summingPrice = productList.stream() 
				               .collect(Collectors.summingInt(Product::getPrice));
		
        
		// Statistiche
		IntSummaryStatistics statistics =productList.stream() 
				  .collect(Collectors.summarizingInt(Product::getPrice));

		// Raggruppamento per prezzo
		Map<Integer, List<Product>> collectorMapOfLists 
		= productList.stream()
		             .collect(Collectors.groupingBy(Product::getPrice));
	
		// Divisione elementi dello stream in due gruppi in accordo a qualche predicato
		Map<Boolean, List<Product>> mapPartioned = productList.stream()
		   .collect(Collectors.partitioningBy(
				   element -> element.getPrice() > 15));		
		
		// Collector supplementare per trasformazioni addizionali
		Set<Product> unmodifiableSet = productList.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(),
				              Collections::unmodifiableSet));

		// Creazione LinkedList di Product
		Collector<Product, ?, LinkedList<Product>> collectorToLinkedList 
				           = Collector.of(LinkedList::new, LinkedList::add,
																			(first, second) -> {
																				first.addAll(second);
																				return first;
																			});
		LinkedList<Product> linkedListOfPersons = productList
				     .stream().collect(collectorToLinkedList);
		
		//	System.out.println("ProductList="+productList.stream().forEach((s) -> System.out.println(s)));
		System.out.println("listToString="+listToString);
		System.out.println("averagePrice="+averagePrice);
		System.out.println("summingPrice="+summingPrice);
		System.out.println("statistics="+statistics.toString());
		System.out.println("collectorMapOfLists="+collectorMapOfLists.toString());	
		System.out.println("mapPartioned="+mapPartioned.toString());	
		System.out.println("unmodifiableSet="+unmodifiableSet.toString());	
		System.out.println("linkedListOfPersons="+linkedListOfPersons.toString());	
	}
	
	
  static class Product {
	 int price;
	 String name;
	 
	public Product(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Product [price=" + price + ", name=" + name + "]";
	}
	
  }
}

package streams;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap implements StreamListMap{

	@Override
	public Map<String, Book> listToMapOldStyle(List<Book> list) {
        
        // Conversione dell'ArrayList in Map
        Map<String, Book> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getIsbn(), list.get(i)); 
        }

		return map;
	}

	@Override
	public Map<String, Book> listToMapWithLambda(List<Book> list) {

//        Map<String, Book> map = new HashMap<>();
//        list.forEach((book)->{       
//        	     	map.put(book.getIsbn(), book);
//        	});
        //esempio ((stringa)->{System.out.println(stringa); return stringa;});
		
		return list.stream()
					.collect(Collectors.toMap(book->book.getIsbn(), book->book));
	}

	@Override
	public Map<String, Book> listToMapWithReference(List<Book> list) {
		return list.stream()
					.collect(Collectors.toMap(Book::getIsbn, book->book));
	}

	@Override
	public Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) {

		return list.stream()
					.collect(Collectors.toMap(Book::getIsbn, Function.identity()));
	}

	@Override
	public Map<String, List<Book>> listToMapWithNoDuplicatesList(List<Book> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Book::getIsbn));
	}
	@Override
	public Map<String, Book> listToMapWithNoDuplicates(List<Book> list) {
		return list.stream()
					.distinct()
					.collect(Collectors.toMap(Book::getIsbn, Function.identity(),(first,second) -> first));
	}

	@Override
	public Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books, String isbn) {
	
		return books.stream() 
					.filter(book -> book.getIsbn().compareTo(isbn)>0)
					.collect(Collectors.groupingBy(Book::getIsbn))
					;
	}

	@Override
	public Map<Boolean, List<Book>> listToMapPriceGreaterThen(List<Book> books, int price) {

		return books
		.stream()
		   .collect(Collectors.partitioningBy(book -> book.getPrice()>price));
	}

	@Override
	public String bookNamesJoined(List<Book> books) {
		return books.stream().map(book->book.getIsbn())
					.collect(Collectors.joining(", "));
		
	}

	@Override
	public double averageBookPrize(List<Book> books) {
		return books.stream() 
					.collect(Collectors.averagingInt(Book::getPrice));
	}

	@Override
	public int totalCost(List<Book> books) {
		return books.stream().collect(Collectors.summingInt(Book::getPrice));
	}

	@Override
	public IntSummaryStatistics booksStatistics(List<Book> books) {
		return books.stream() 
				.collect(Collectors.summarizingInt(Book::getPrice));
	}

	@Override
	public String[] booksAuthors(List<Book> books) {
		return (String[]) books.stream()
					.map(book->book.getAuthor())
					.toArray()
					//.collect(Collectors.toList())
					//.toArray(new String[0])
					;
	}

	@Override
	public String[] booksAuthors(List<Book> books, String nazione) {
				return (String[]) books.stream()
						.filter(book -> book.getNazione().compareTo(nazione)==1)
						.map(book->book.getAuthor())
						.toArray();						
	}

}

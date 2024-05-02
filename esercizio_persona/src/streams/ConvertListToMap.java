package streams;

import java.nio.file.DirectoryStream.Filter;
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
            map.put(list.get(i).isbn, list.get(i)); 
        }

		return map;
	}

	@Override
	public Map<String, Book> listToMapWithLambda(List<Book> list) {

        Map<String, Book> map = new HashMap<>();
        list.forEach((book)->{       
        	     	map.put(book.isbn, book);
        	});
        //esempio ((stringa)->{System.out.println(stringa); return stringa;});
		
		return map;
	}

	@Override
	public Map<String, Book> listToMapWithReference(List<Book> list) {
        Map<String, Book> map = list.stream().collect(Collectors.toMap(Book::getIsbn, book->book));

		return map;
	}

	@Override
	public Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) {
        Map<String, Book> map = list.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity()));
		return map;
	}

	@Override
	public Map<String, List<Book>> listToMapWithNoDuplicatesList(List<Book> list) {
		Map<String, List<Book>> map = list.stream().collect(Collectors.groupingBy(Book::getIsbn));
		return map;
	}
	@Override
	public Map<String, Book> listToMapWithNoDuplicates(List<Book> list) {
        Map<String, Book> map = list.stream().distinct().collect(Collectors.toMap(Book::getIsbn, Function.identity(),(first,second) -> first));
		return map;
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

		return books.stream()
					.filter(book -> book.getPrice().compareTo(price)>0)
					.collect(Collectors.groupingBy(Book::getPrice))
					;
					
	}

	@Override
	public String bookNamesJoined(List<Book> books) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double averageBookPrize(List<Book> books) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalCost(List<Book> books) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IntSummaryStatistics booksStatistics(List<Book> books) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] booksAuthors(List<Book> books) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] booksAuthors(List<Book> books, String nazione) {
		// TODO Auto-generated method stub
		return null;
	}

}

package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book<T> {
	private String isbn;

	private String desc;

	private String author;

	private String nazione;

	private int price;
	
	List<String> books;

	public Book(String isbn, String desc, String author, String nazione , int price) {
		super();
		this.isbn = isbn;
		this.desc = desc;
		this.author = author;
		this.nazione = nazione;
		this.price=price;
		books=new ArrayList<String>();
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the nazione
	 */
	public String getNazione() {
		return nazione;
	}

	/**
	 * @param nazione the nazione to set
	 */
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(author, books, desc, isbn, nazione, price);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(books, other.books)
				&& Objects.equals(desc, other.desc) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(nazione, other.nazione) && price == other.price;
	}
}

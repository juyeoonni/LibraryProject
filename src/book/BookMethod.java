package book;

import java.util.*;

import member.*;

public class BookMethod {
	
	private static List<Book> booklist = new ArrayList<>();
	
	public void addBooks(String isbn, String title, String author, String publisher, String publicationDate, boolean isAvailable) {
		Book book = new Book(isbn, title, author, publisher, publicationDate, isAvailable);
		booklist.add(book);
	}
	
}

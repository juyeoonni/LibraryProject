package book;

import java.time.LocalDate;
import java.util.*;

import member.*;

public class Book {
	private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private boolean isAvailable;
    
    public Book(String isbn, String title, String author, String publisher, String publicationDate, boolean isAvailable) {
    	this.isbn = isbn;
    	this.title = title;
    	this.author = author;
    	this.publisher = publisher;
    	this.publicationDate = publicationDate;
    	this.isAvailable = isAvailable;
    }
    
    
    
    public Book() {
		// TODO Auto-generated constructor stub
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	

	public void setAvailable(boolean available) {
        isAvailable = available;
    }
	
	
}

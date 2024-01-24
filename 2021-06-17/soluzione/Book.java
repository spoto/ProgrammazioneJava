package it.univr.books;

public class Book {
	public final String title;
	public final int pages;
	public final int height;
	public final LANGUAGE language;

	public enum LANGUAGE {
		ITALIAN,
		ENGLISH,
		FRENCH
	}

	public Book(String title, int pages, int height, LANGUAGE language) {
		this.title = title;
		this.pages = pages;
		this.height = height;
		this.language = language;
	}

	@Override
	public String toString() {
		return title;
	}
}
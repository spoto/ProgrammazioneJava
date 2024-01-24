package it.univr.books;

import java.util.Set;
import java.util.TreeSet;

public class LibraryBySize extends Library {

	public LibraryBySize(int height) {
		super(height);
	}

	@Override
	protected Set<Book> makeSet() {
		// oppure usando una classe interna che implementa Comparator
		return new TreeSet<>(this::compare);
	}

	private int compare(Book book1, Book book2) {
		int diff = book1.height - book2.height;
		if (diff != 0)
			return diff;
		else
			return book1.title.compareTo(book2.title);
	}
}

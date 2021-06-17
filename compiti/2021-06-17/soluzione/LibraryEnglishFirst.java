package it.univr.books;

import java.util.Set;
import java.util.TreeSet;

public class LibraryEnglishFirst extends Library {

	public LibraryEnglishFirst(int height) {
		super(height);
	}

	@Override
	protected Set<Book> makeSet() {
		// oppure usando una classe interna che implementa Comparator
		return new TreeSet<>(this::compare);
	}

	private int compare(Book book1, Book book2) {
		if (book1.language == Book.LANGUAGE.ENGLISH && book2.language != Book.LANGUAGE.ENGLISH)
			return -1;
		else if (book2.language == Book.LANGUAGE.ENGLISH && book1.language != Book.LANGUAGE.ENGLISH)
			return 1;
		else
			return book1.title.compareTo(book2.title);
	}
}

package it.univr.books;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Una libreria contiene un insieme di libri.
 */
public class Library implements Iterable<Book> {
	// l'altezza della libreria: non puo' contenere libri piu' alti di questo valore
	private final int height;
	
	// i libri che fanno parte della libreria
	private final Set<Book> books;

	// costruisce una libreria con una certa altezza
	public Library(int height) {
		this.height = height;
		this.books = makeSet();
	}

	// costruisce il contenitore dei libri della libreria, inizialmente vuoto
	protected Set<Book> makeSet() {
		return new HashSet<>();
	}

	// aggiunge un libro alla libreria. Deve lanciare
	// una IllegalArgumentException se il libro e' troppo alto per entrare nella libreria
	public void add(Book book) throws IllegalArgumentException {
		if (book.height > height)
			throw new IllegalArgumentException("Book too high!");

		books.add(book);
	}

	@Override
	public Iterator<Book> iterator() {
		return books.iterator();
	}

	// itera sulla libreria e restituisce la concatenzazione
	// dei titoli dei libri della libreria
	@Override
	public String toString() {
		String result = "";
		for (Book book: this)
			result += book + "\n";
		
		return result;
	}
}
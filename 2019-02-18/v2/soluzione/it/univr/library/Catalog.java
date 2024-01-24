package it.univr.library;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Un catalogo contiene dei libri (senza ripetizioni).
 */
public class Catalog implements Iterable<Book> {
	private final SortedSet<Book> books;

	/**
	 * Costruisce un catalogo. L'ordinamento sara' quello del
	 * compareTo definito in Book.
	 * 
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public Catalog(Book... books) {
		this.books = new TreeSet<>();

		for (Book book: books)
			this.books.add(book);
	}

	/**
	 * Costruisce un catalogo. L'ordinamento sara' quello del comparatore fornito.
	 * 
	 * @param comparator l'oggetto che determina l'ordine fra due libri
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public Catalog(Comparator<Book> comparator, Book... books) {
		this.books = new TreeSet<>(comparator);

		for (Book book: books)
			this.books.add(book);
	}

	@Override
	public Iterator<Book> iterator() {
		return books.iterator();
	}

	/**
	 * Restituisce il toString dei libri contenuti in questo catalogo, nel loro ordine,
	 * andando a capo dopo ciascuno di essi.
	 */
	@Override
	public String toString() {
		String result = "";
		for (Book book: this)
			result += book + "\n";

		return result;
	}
}
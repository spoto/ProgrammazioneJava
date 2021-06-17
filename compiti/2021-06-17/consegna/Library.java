// Create un nuovo progetto Java con un package it.univr.books dentro il quale
// copiate questa classe, Book.java e Main.java

// Completate questa classe dove indicato con TODO, in modo che alla fine compili

// Poi scrivere una sottoclasse LibraryBySize di Library che
// tiene i libri ordinati per altezza crescente; a parita' di altezza,
// li tiene ordinati alfabeticamente per titolo

// Poi scrivere una sottoclasse LibraryEnglishFirst di Library che
// tiene i suoi libri mettendo prima gli inglesi e poi quelli delle altre lingue;
// se due libri sono entrambi inglesi (o nessuno dei due e' inglese) li mette poi
// in ordine alfabetico per titolo

// SUGGERIMENTO: si ricordi che la classe di libreria java.util.TreeSet ha un costruttore
// che riceve come argomento un java.util.Comparator che specifica
// in che ordine deve tenere i suoi elementi

package it.univr.books;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Una libreria contiene un insieme di libri.
 * Iterando su una libreria si ottengono i libri contenuti
 * nel suo campo "books".
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
		// TODO
	}

	// TODO
	
	// itera sulla libreria e restituisce la concatenzazione
	// dei titoli dei libri della libreria
	@Override
	public String toString() {
		return ""; // TODO
	}
}
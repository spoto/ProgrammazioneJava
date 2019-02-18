package it.univr.library;

/**
 * Un libro.
 */
public abstract class Book implements Comparable<Book> {
	
	/**
	 * Crea un libro.
	 * 
	 * @param title il titolo del libro
	 * @param author l'autore del libro
	 * @param year l'anno di pubblicazione del libro
	 * @param genre il genere del libro
	 * @throws IllegalArgumentException se qualche parametro e' null
	 */
	protected Book(String title, String author, int year, Genre genre) {
		// TODO
	}

	/**
	 * Restituisce il titolo del libro.
	 */
	public String getTitle() {
		return null; //TODO
	}

	/**
	 * Restituisce l'autore del libro.
	 */
	public String getAuthor() {
		return null; //TODO
	}

	/**
	 * Restituisce il genere del libro.
	 */
	public Genre getGenre() {
		return null; //TODO
	}

	/**
	 * Restituisce l'anno di pubblicazione del libro.
	 */
	public int getYear() {
		return 0; //TODO
	}

	/**
	 * Ritorna il titolo fra doppi apici seguito dall'autore e poi
	 * (fra parentesi) anno di pubblicazione e genere.
	 */
	@Override
	public String toString() {
		return ""; //TODO
	}

	/**
	 * Due libri sono equals se hanno stesso titolo, autore e anno di pubblicazione.
	 * Il genre non viene preso in considerazione.
	 */
	@Override
	public boolean equals(Object other) {
		return false; //TODO
	}

	@Override
	public int hashCode() {
		return 0; // TODO, non banale
	}

	/**
	 * Due libri sono ordinati per titolo; a parità di titolo, sono ordinati per autore;
	 * a parità anche di autore, sono ordinati per anno di pubblicazione.
	 */
	@Override
	public int compareTo(Book other) {
		return 0; //TODO
	}
}
package it.univr.library;

/**
 * Un audio-libro.
 */
public class AudioBook extends Book {
	private final int minutes;

	/**
	 * Crea un audio-libro.
	 * 
	 * @param title il titolo del libro
	 * @param author l'autore del libro
	 * @param year l'anno di pubblicazione del libro
	 * @param genre il genere del libro
	 * @param minutes la durata del libro in minuti
	 * @throws IllegalArgumentException se qualche parametro e' null o se minutes e' negativo
	 */
	public AudioBook(String title, String author, int year, Genre genre, int minutes) {
		super(title, author, year, genre);

		if (minutes < 0)
			throw new IllegalArgumentException();

		this.minutes = minutes;
	}

	/**
	 * Ritorna il numero di minuti dell'audio-libro.
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Si comporta come il toString di Book ma aggiunge in fondo la durata
	 * in minuti fra parentesi quadre.
	 */
	@Override
	public String toString() {
		return super.toString() + " [" + minutes + " minutes]";
	}

	/**
	 * Si comporta come l'equals di Book ma in piu' richiede che other sia un AudioBook.
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof AudioBook && super.equals(other);
	}

	/**
	 * Si comporta come il compareTo di Book ma, a parità di titolo, autore e anno,
	 * mette prima i PaperBook e poi gli AudioBook.
	 */
	@Override
	public int compareTo(Book other) {
		int diff = super.compareTo(other);
		if (diff != 0)
			return diff;
		else if (other instanceof PaperBook)
			return 1;
		else
			return 0;
	}
}
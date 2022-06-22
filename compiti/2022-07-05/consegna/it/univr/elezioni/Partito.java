package it.univr.elezioni;

/**
 * Un partito ha un nome, passato al momento della costruzione.
 */
public class Partito implements Comparable<Partito> {

	public Partito(String nome) {
		// completare
	}

	/**
	 * Determina chi fra this e other viene prima in ordine alfabetico per nome.
	 */
	@Override
	public int compareTo(Partito other) {
		return 0; // modificare
	}

	// due partiti sono uguali se e solo se hanno nome uguale
	@Override
	public boolean equals(Object other) {
		return false; // modificare
	}

	@Override
	public int hashCode() {
		return 0; // modificare in modo che sia non banale
	}

	/**
	 * Restituisce il nome del partito.
	 */
	@Override
	public String toString() {
		return ""; // modificare
	}
}
package it.univr.letters;

import java.util.function.Consumer;

/**
 * Una sequenza di lettere (cioe' caratteri alfabetici).
 */
public interface Letters {

	/**
	 * Restituisce la lunghezza della sequenza.
	 */
	int length();

	/**
	 * Restituisce la concatenazione delle lettere della sequenza.
	 */
	String toString();

	/**
	 * Applica il comando indicato alle lettere della sequenza
	 * (dalla prima all'ultima).
	 */
	void forEach(Consumer<Character> command);
}
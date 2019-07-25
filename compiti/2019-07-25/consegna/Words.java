package it.univr.words;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Una lista di parole, estratte da un file di testo.
 */
public class Words { // TODO

	/**
	 * Crea una lista di parole, estraendole dal file di testo
	 * col nome indicato.
	 * 
	 * @param fileName il nome del file di testo
	 * @throws IOException se si verifica un errore di accesso al file
	 */
	public Words(String fileName) throws IOException {
		// TODO
	}

	/**
	 * Crea una lista di parole, estraendole dal file di testo
	 * col nome indicato e selezionando solo quelle che soddisfano
	 * il selettore fornito.
	 * 
	 * @param fileName il nome del file di testo
	 * @param selector il selettore usato per selezionare le parole da estrarre
	 * @throws IOException se si verifica un errore di accesso al file
	 */
	public Words(String fileName, Predicate<String> selector) throws IOException {
		//TODO
	}

	/**
	 * Ridefinito in modo da fargli stampare "a list of XX words", dove
	 * "XX e' la lunghezza di questa lista di parole.
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	/**
	 * Restituisce la parola piu' frequente fra quelle presenti in questa
	 * lista di parole.
	 * 
	 * @return la parola piu' frequente
	 * @throws NoSuchElementException se questa lista e' vuota
	 */
	public String mostFrequent() {
		return ""; // TODO
	}
}

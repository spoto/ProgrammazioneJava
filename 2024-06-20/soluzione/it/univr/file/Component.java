package it.univr.file;

import java.io.FileNotFoundException;
import java.util.List;

public interface Component {

	/**
	 * Ritorna il nome della componente
	 * (nome del file o nome della directory).
	 */
	String getName();

	/**
	 * Ritorna una stringa che rappresenta la componente e le sottocomponenti,
	 * ricorsivamente, come nel testo del compito. Il contenuto di una directory
	 * deve venire riportato in ordine alfabetico crescente per nome.
	 */
	String toString();

	/**
	 * Identico a toString() sopra, ma la stringa ritornata ha i caratteri
	 * nesting alla sua sinistra, in ogni riga.
	 */
	String toString(String nesting);

	/**
	 * Ritorna la dimensione totale, in byte, della componente
	 * e delle sue sottocomponenti. Per i file, e' la dimensione
	 * del file. Per le directory, e' 100 piu' la somma delle dimensioni
	 * del contenuto della directory, ricorsivamente.
	 */
	int size();

	/**
	 * Ritorna le componenti di tipo file raggiungibili da questa
	 * componente, ricorsivamente.
	 */
	List<FileComponent> getFiles();

	/**
	 * Restituisce una descrizione del persorso con cui si raggiunge
	 * un file con il nome indicato, se esiste a partire da questa componente.
	 * Il risultato separa i nomi delle componenti con il carattere /
	 * Lancia l'eccezione se non esiste nessun file con il nome cercato.
	 */
	String find(String name) throws FileNotFoundException;
}
package it.univr.figures;

/**
 * Una disegno di una figura.
 */
public interface Figure {

	// restituisce la larghezza della figura (numero di caratteri orizzontalmente)
	int getWidth();

	// restituisce l'altezza della figura (numero di caratteri verticalmente)
	int getHeight();

	/**
	 * Restituisce la riga n-esima della figura. Come se affettassimo
	 * orizzontalmente la figura e prendessimo solo una riga.
	 * 
	 * @param n il numero della riga della figura, tra 0 incluso e getHeight() escluso
	 * @return la riga n-esima della figura (senza nessuna andata a capo alla fine)
	 * @throws NoSuchRowException se n è fuori dai limiti previsti
	 */
	String getRow(int n) throws NoSuchRowException;

	/**
	 * Restituisce una rappresentazione stringa della figura. Sarà ottenuta
	 * concatenando i getRow() di tutte le righe della figura, aggiungendo
	 * un'andata a capo alla fine di ciascun getRow().
	 * 
	 * @return la rappresentazione stringa
	 */
	String toString();
}
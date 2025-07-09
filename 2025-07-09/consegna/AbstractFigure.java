package it.univr.figures;

/**
 * Un'implementazione parziale di una figura. Implementa solo il toString(),
 * gli altri metodi dell'interfaccia saranno implementati dalle sottoclassi.
 */
public abstract class AbstractFigure implements Figure {

	/**
	 * Restituisce una rappresentazione stringa della figura. Sarà ottenuta
	 * concatenando i getRow() di tutte le righe della figura, aggiungendo
	 * un'andata a capo alla fine di ciascun getRow().
	 * 
	 * @return la rappresentazione stringa
	 */
	@Override
	public final String toString() {
		return ""; // COMPLETATE
	}
}
package it.univr.supermarket;

/**
 * Un prodotto con un momento di scadenza.
 */
public class ProductWithExpiration extends Product {

	// TODO: campi?

	/**
	 * Costruisce un prodotto con una scadenza.
	 * 
	 * @param name il nome del prodotto
	 * @param price il prezzo in euro del prodotto
	 * @param whenProduced il momento di produzione (millisecondi da 1/1/1970)
	 * @param duration il numero di giorni, successivi all produzione, dopo i quali il prodotto scade
	 * @throws IllegalArgumentException se name e' null oppure vuota oppure se price e' negativo
	 *                                  oppure se whenProduced e' negativo oppure su duration e' negativo
	 */
	public ProductWithExpiration(String name, double price, long whenProduced, int duration) {
	  // TODO
	}

	// TODO
}

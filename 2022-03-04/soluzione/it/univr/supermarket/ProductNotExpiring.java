package it.univr.supermarket;

/**
 * Un prodotto che non scade mai.
 */
public class ProductNotExpiring extends Product {

	/**
	 * Costruisce un prodotto senza scadenza.
	 * 
	 * @param name il nome del prodotto
	 * @param price il prezzo in euro del prodotto
	 * @throws IllegalArgumentException se name e' null oppure vuota oppure se price e' negativo
	 */
	public ProductNotExpiring(String name, double price) {
		super(name, price);
	}

	@Override
	public boolean hasExpired(long whenChecked) {
		return false;
	}

	@Override
	protected int compareExpiration(Product other) {
		return other instanceof ProductWithExpiration ? 1 : 0;
	}
}
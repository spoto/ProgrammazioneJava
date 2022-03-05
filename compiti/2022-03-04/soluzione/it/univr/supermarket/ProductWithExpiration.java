package it.univr.supermarket;

/**
 * Un prodotto con un momento di scadenza.
 */
public class ProductWithExpiration extends Product {
	private final long expiration;

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
		super(name, price);

		if (whenProduced < 0 || duration < 0)
			throw new IllegalArgumentException();

		this.expiration = whenProduced + duration * _24_HOURS;
	}

	@Override
	public boolean hasExpired(long whenChecked) {
		return whenChecked >= expiration;
	}

	@Override
	protected int compareExpiration(Product other) {
		if (other instanceof ProductNotExpiring)
			return -1;
		else
			return Long.compare(expiration, ((ProductWithExpiration) other).expiration);
	}
}
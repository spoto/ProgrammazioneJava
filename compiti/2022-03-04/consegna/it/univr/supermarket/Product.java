package it.univr.supermarket;

/**
 * Un prodotto del supermercato.
 */
public abstract class Product implements Comparable<Product> {

	/**
	 * Il nome del prodotto.
	 */
	private final String name;

	/**
	 * Il prezzo in euro del prodotto.
	 */
	private final double price;

	/**
	 * Il numero di milliseocndi che formano 24 ore (un giorno).
	 */
	public final static long _24_HOURS = 1000L * 60 * 60 * 24;

	/**
	 * Costruisce un prodotto.
	 * 
	 * @param name il nome del prodotto
	 * @param price il prezzo in euro del prodotto
	 * @throws IllegalArgumentException se name e' null oppure vuoto oppure price e' negativo
	 */
	protected Product(String name, double price) {
		this.name = name;
		this.price = price;
		
		// TODO
	}

	@Override
	public final String toString() {
		return name;
	}

	/**
	 * Confronta il momento di scadenza di questo prodotto con quello di un altro prodotto.
	 * 
	 * @return un numero negativo se questo prodotto scade prima di other;
	 *         un numero positivo se questo prodotto scade dopo other;
	 *         0 se questo prodotto e other scadono nello stesso momento (o entrambi non scadono mai)
	 */
	protected abstract int compareExpiration(Product other);

	/**
	 * Due prodotti sono equals se hanno stesso nome, stesso prezzo e stesso momento di scadenza.
	 */
	@Override
	public final boolean equals(Object other) {
		return true; // TODO
	}

	/**
	 * Non deve essere banale.
	 */
	@Override
	public final int hashCode() {
		return 0; // TODO
	}

	/**
	 * Determina se, al momento indicato, questo prodotto e' scaduto.
	 * 
	 * @param whenChecked il momento indicato
	 */
	public abstract boolean hasExpired(long whenChecked);

	/**
	 * Determina se, al momento indicato, questo prodotto non e' ancora
	 * scaduto ma scadra' nelle 24 ore successive.
	 *
	 * @param whenChecked il momento indicato (in millisecondi da 1/1/1970)
	 */
	public final boolean expiresInSubsequent24Hours(long whenChecked) {
		return true; // TODO
	}

	/**
	 * Restituisce il prezzo di questo prodotto, come e' stato fornito al costruttore.
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * Si comporta identicamente al getPrice() che c'e' sopra, ma restituisce
	 * un prezzo scontato del 40% se, al momento indicato, questo prodotto non e' ancora
	 * scaduto ma scadra' nelle 24 ore successive.
	 *  
	 * @param whenChecked il momento in cui si chiede di controllare il prezzo (in millisecondi da 1/1/1970)
	 * @return il prezzo del prodotto, possibilmente scontato
	 */
	public final double getPrice(long whenChecked) {
		return 0.0; // TODO
	}

	/**
	 * Ordina i prodotti per momento di scadenza (si usi compareExpiration),
	 * poi per nome e infine per prezzo (si usi il metodo statico della libreria
	 * Double.compare(double1, double2)).
	 */
	@Override
	public final int compareTo(Product other) {
		return 0; // TODO
	}
}
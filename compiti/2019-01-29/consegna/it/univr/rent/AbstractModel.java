package it.univr.rent;

// Ci sono 6 TODO

public abstract class AbstractModel implements Model {

	/**
	 * Crea un modello col nome e prezzo giornaliero indicato.
	 * 
	 * @param name il nome
	 * @param pricePerDay il prezzo giornaliero
	 */
	protected AbstractModel(String name, int pricePerDay) {
		// TODO
	}

	/**
	 * Restituisce il nome di questo modello.
	 */
	@Override
	public final String getName() {
		return ""; //TODO
	}

	/**
	 * Restituisce il prezzo giornaliero di noleggio di questo modello.
	 */
	@Override
	public final int pricePerDay() {
		return 0; // TODO
	}

	/**
	 * Restituisce il nome di questo modello.
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	/**
	 * I modelli sono ordinari per prezzo di noleggio crescente. A parita'
	 * di prezzo di noleggio, sono ordinati alfabeticamente per nome.
	 */
	@Override
	public final int compareTo(Model other) {
		return 0; // TODO
	}

	/**
	 * Due modelli sono uguali se appartengono alla stessa
	 * classe (due Car, due Motorbike...) e se hanno stesso nome
	 * e stesso prezzo di noleggio giornaliero. Si noti che questo metodo
	 * e' abstract, quindi dove verra' implementato?
	 */
	@Override
	public abstract boolean equals(Object other);

	@Override
	public int hashCode() {
		return 0; // TODO, non banale!
	}
}

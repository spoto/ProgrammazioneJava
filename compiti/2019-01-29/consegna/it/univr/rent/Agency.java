package it.univr.rent;

import java.util.Set;

// Ci sono 5 TODO

public class Agency {

	/**
	 * Crea un'agenzia di noleggio col nome indicato,
	 * che fornisce in noleggio i modelli indicati.
	 * 
	 * @param fleet i modelli noleggiabili con l'agenzia
	 * @throws IllegalArgumentException se fleet e' vuoto
	 */
	public Agency(String name, Model... fleet) {
		// TODO
	}

	/**
	 * Restituisce l'insieme dei modelli noleggiabili con questa agenzia
	 * e con la patente indicata.
	 * 
	 * @param license la patente
	 */
	public Set<Model> modelsAvailableForLicense(License license) {
		return null; // TODO
	}

	/**
	 * Pende nota che qualcuno ha noleggiato con questa agenzia un dato modello,
	 * per una certa quantita' di giorni, usando la patente indicata.
	 * 
	 * @param model il modello noleggiato
	 * @param license la patente
	 * @param days il numero di giorni di noleggio
	 * @throws IllegalLicenseException se il modello non si puo' guidare
	 *                                 con la patente indicata
	 * @throws ModelNotAvailableException se il modello non e' fra quelli
	 *                                    noleggiabili con questa agenzia
	 */
	public void rent(Model model, License license, int days) {
		// TODO
	}

	/**
	 * Restituisce il modello che e' stato noleggiato in totale per piu' giorni
	 * con questa agenzia.
	 */
	public Model mostRented() {
		return null; //TODO
	}

	/**
	 * Restituisce una stringa con in prima riga il nome dell'agenzia e,
	 * sotto di essa, la lista dei modelli noleggiabili con questa agenzia,
	 * ordinati secondo l'ordinamento fra i modelli.
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}
}
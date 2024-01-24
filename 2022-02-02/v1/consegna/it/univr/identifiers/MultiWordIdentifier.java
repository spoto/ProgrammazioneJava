package it.univr.identifiers;

import java.util.List;

// un identificatore fatto da piu' parole in sequenza
public abstract class MultiWordIdentifier implements Identifier {

	// TODO

	// fallisce con una IllegalArgumentException se non c'e' nessuna parola
	// o se c'e' una parola null oppure vuota
	// o se una parola contiene un carattere non alfabetico
	protected MultiWordIdentifier(String... words) throws IllegalArgumentException {
		// TODO
	}

	// fallisce con un'eccezione nelle stesse condizioni viste sopra
	protected MultiWordIdentifier(Iterable<String> words) throws IllegalArgumentException {
		// TODO
	}

	@Override
	public final String toString() {
		// TODO: si richiami il metodo ausiliario toString(pos, word)
		// e si concateni il risultato in un'unica stringa
		return "";
	}

	// restituisce la stringa con cui si stampa la componente pos-esima dell'identificatore
	protected abstract String toString(int pos, String word);

	// restituisce la concatenazione delle parole degli identificatori indicati
	protected static List<String> concat(MultiWordIdentifier... ids) {
		return null; // TODO
	}

	// POTETE AGGIUNGERE METODI PRIVATE
}

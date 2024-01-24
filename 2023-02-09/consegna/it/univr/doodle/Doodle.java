package it.univr.doodle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Doodle {
	// per ogni persona, dice in quali slot temporali è disponibile
	private final Map<Person, Set<Slot>> availabilities = new HashMap<>();

	// aggiunge gli slot temporali "when" a quelli disponibili per person
	public void available(Person person, Slot... when) {
		//
	}

	// aggiunge gli slot temporali "when" a quelli disponibili per person
	public void available(Person person, Iterable<Slot> when) {
		//
	}

	// costruisce una tabella come negli esempi del compito:
	// nella prima riga tutti gli slot temporali in "availabilities",
	// in ordine crescente;
	// poi le disponibilità di ciascuna persona in "availabilities"
	// poi la priorità di ciascuno slot temporale (somma delle priorità di
	// chi può partecipare), con un asterisco a lato del primo slot
	// con piorità massima
	public String toString() {
		String result = "";
		//
		return result;
	}

	protected int priority(Person person) {
		return 1; // non modificate: per default i doodle danno a tutti la stessa priorità (1)
	}
}

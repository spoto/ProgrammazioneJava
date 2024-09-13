package it.univr.corso;

import java.time.Year;

/**
 * Uno studente lavoratore e' identico a uno studente ma finisce fuori corso
 * nel doppio di anni rispetto a uno studente non lavoratore.
 */
public class StudenteLavoratore extends Studente {

	public StudenteLavoratore(String nome, String cognome, int matricola, int annoDiImmatricolazione) throws StudenteIllegaleException {
		super(nome, cognome, matricola, annoDiImmatricolazione);
	}

	@Override
	public boolean fuoriCorso(Corso corso) {
		int annoCorrente = Year.now().getValue();
		return getAnnoDiImmatricolazione() < annoCorrente - corso.getDurata() * 2;
	}
}
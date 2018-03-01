package it.univr.esami;

public class VerbalizzazioneGiàEffettuataException extends Exception {
	public VerbalizzazioneGiàEffettuataException(Studente studente) {
		super("Lo studente " + studente.nome + " " + studente.cognome + " ha già verbalizzato");
	}
}

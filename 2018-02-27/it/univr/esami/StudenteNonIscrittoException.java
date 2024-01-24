package it.univr.esami;

public class StudenteNonIscrittoException extends Exception {
	public StudenteNonIscrittoException(Studente studente) {
		super("Lo studente " + studente.nome + " " + studente.cognome + " non è iscritto all'esame");
	}
}

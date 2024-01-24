package it.univr.palestra;

public class IscrizioneTroppoLungaException extends Exception {
	public IscrizioneTroppoLungaException() {
		super("l'iscrizione deve essere di al massimo un anno");
	}
}
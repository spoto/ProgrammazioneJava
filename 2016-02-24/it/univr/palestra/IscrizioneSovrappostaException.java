package it.univr.palestra;

public class IscrizioneSovrappostaException extends Exception {
	public IscrizioneSovrappostaException() {
		super("l'iscrizione è sovrapposta a un'altra già esistente");
	}
}
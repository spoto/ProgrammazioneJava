package it.univr.palestra;

public class IscrizioneVuotaException extends Exception {
	public IscrizioneVuotaException() {
		super("l'inizio dell'iscrizione deve precederne la fine");
	}
}
package it.univr.agenda;

// Ci sono 3 TODO

public class ItalianTime extends Time {
	
	/**
	 * Costruisce un istante con notazione italiana.
	 * 
	 * @param hours le ore, tra 0 e 23
	 * @param minutes i minuti, tra 0 e 59
	 * @param seconds i secondi, tra 0 e 59
	 * @throws IllegalArgumentException se i parametri non fossero validi
	 */
	public ItalianTime(int hours, int minutes, int seconds) {
		super(0); //TODO
	}

	/**
	 * @return una stringa nel formato hh:mm:ss (ore, minuti e secondi sempre su due cifre!)
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	@Override
	public ItalianTime after(int minutes) {
		return null; // TODO
	}
}

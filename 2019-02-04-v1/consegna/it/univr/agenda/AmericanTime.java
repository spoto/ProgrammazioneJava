package it.univr.agenda;

// Ci sono 3 TODO

public class AmericanTime extends Time {
	public enum Period {
		AM, PM
	}

	/**
	 * Costruisce un istante con notazione americana.
	 * 
	 * @param hours le ore, tra 1 e 12
	 * @param minutes i minuti, tra 0 e 59
	 * @param seconds i secondi, tra 0 e 59
	 * @param period il periodo del giorno
	 * @throws IllegalArgumentException se i parametri non fossero validi
	 */
	public AmericanTime(int hours, int minutes, int seconds, Period period) {
		super(0); //TODO
	}

	/**
	 * @return una stringa nel formato hh:mm:ssPP, dove PP e' il periodo
	 * e quindi puo' essere AM oppure PM (ore, minuti e secondi sempre su due cifre!)
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	@Override
	public AmericanTime after(int minutes) {
		return null; // TODO
	}
}
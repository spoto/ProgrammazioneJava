package it.univr.agenda;

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
		super(seconds + 60 * minutes + 3600 * hours);

		if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60)
			throw new IllegalArgumentException();
	}

	private ItalianTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	/**
	 * @return una stringa nel formato hh:mm:ss (ore, minuti e secondi sempre su due cifre!)
	 */
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", secondsFromStartOfDay / 3600, (secondsFromStartOfDay / 60) % 60, secondsFromStartOfDay % 60);
	}

	@Override
	public ItalianTime after(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();

		return new ItalianTime((secondsFromStartOfDay + minutes * 60) % (24 * 60 * 60));
	}
}

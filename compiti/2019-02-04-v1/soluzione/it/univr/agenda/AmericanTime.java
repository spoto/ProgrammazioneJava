package it.univr.agenda;

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
		super(seconds + 60 * minutes + 3600 * translateHours(period, hours));

		if (hours < 1 || hours > 12 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60)
			throw new IllegalArgumentException();
	}

	private AmericanTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	private static int translateHours(Period period, int hours) {
		if (hours == 12)
			hours = 0;

		if (period == Period.AM)
			return hours;
		else
			return hours + 12;
	}

	/**
	 * @return una stringa nel formato hh:mm:ssPP, dove PP e' il periodo
	 * e quindi puo' essere AM oppure PM (ore, minuti e secondi sempre su due cifre!)
	 */
	@Override
	public String toString() {
		Period period;

		int hours = (secondsFromStartOfDay / 3600);
		if (hours < 12)
			period = Period.AM;
		else
			period = Period.PM;

		if (hours == 0)
			hours = 12;
		else if (hours > 12)
			hours -= 12;

		return String.format("%02d:%02d:%02d%s", hours, (secondsFromStartOfDay / 60) % 60, secondsFromStartOfDay % 60, period);
	}

	@Override
	public AmericanTime after(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();

		return new AmericanTime((secondsFromStartOfDay + minutes * 60) % (24 * 60 * 60));
	}
}
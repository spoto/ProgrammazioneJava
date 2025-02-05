package it.univr.time;

public class AmericanTime extends AbstractTime {

	public AmericanTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		return new AmericanTime((getSecondsFromStartOfDay() + 1) % SECONDS_IN_ONE_DAY);
	}

	// restituisce una stringa che rappresenta un Time all'americana (am/pm)
	public String toString() {
		int secondsFromStartOfDay = getSecondsFromStartOfDay();
		int seconds = secondsFromStartOfDay % 60;
		int minutes = secondsFromStartOfDay / 60 % 60;
		int hours = secondsFromStartOfDay / 3600; // tra 0 e 23

		if (hours == 0)
			return String.format("12:%02d:%02dam", minutes, seconds);
		else if (hours < 12)
			return String.format("%02d:%02d:%02dam", hours, minutes, seconds);
		else if (hours == 12)
			return String.format("12:%02d:%02dpm", minutes, seconds);
		else
			return String.format("%02d:%02d:%02dpm", (hours - 12), minutes, seconds);
	}
}
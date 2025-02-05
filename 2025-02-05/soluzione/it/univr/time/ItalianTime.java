package it.univr.time;

public class ItalianTime extends AbstractTime {

	public ItalianTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		return new ItalianTime((getSecondsFromStartOfDay() + 1) % SECONDS_IN_ONE_DAY);
	}

	// restituisce una stringa che rappresenta un Time all'italiana
	public String toString() {
		int secondsFromStartOfDay = getSecondsFromStartOfDay();
		int seconds = secondsFromStartOfDay % 60;
		int minutes = secondsFromStartOfDay / 60 % 60;
		int hours = secondsFromStartOfDay / 3600;

		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
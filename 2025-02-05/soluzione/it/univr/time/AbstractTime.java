package it.univr.time;

// implementazione parziale di un Time
public abstract class AbstractTime implements Time {

	// il numero di secondi in un giorno
	public final static int SECONDS_IN_ONE_DAY = 24 * 60 * 60;

	// i secondi passati dall'inizio del giorno
	private final int secondsFromStartOfDay;

	// crea un Time che rappresenta l'istante di tempo
	// secondsFromStartOfDay secondi dall'inizio del giorno;
	// lancia IllegalArgumentException se secondsFromStartOfDay è negativo
	// oppure se è maggiore o uguale a SECONDS_IN_ONE_DAY
	protected AbstractTime(int secondsFromStartOfDay) {
		if (secondsFromStartOfDay < 0 || secondsFromStartOfDay >= SECONDS_IN_ONE_DAY)
			throw new IllegalArgumentException();

		this.secondsFromStartOfDay = secondsFromStartOfDay;
	}

	// metodo accessore
	public final int getSecondsFromStartOfDay() {
		return secondsFromStartOfDay;
	}

	// ritorna true se e solo se other è un Time che ha lo stesso getSecondsFromStartOfDay()
	public boolean equals(Object other) {
		return other instanceof Time time && secondsFromStartOfDay == time.getSecondsFromStartOfDay();
	}

	// non banale
	public int hashCode() {
		return secondsFromStartOfDay;
	}

	public Interval interval(int howManySeconds) {
		return new Interval(this, howManySeconds);
	}
}
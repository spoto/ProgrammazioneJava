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
		// completate
	}

	// metodo accessore
	public final int getSecondsFromStartOfDay() {
		// completate
	}

	// ritorna true se e solo se other è un Time che ha lo stesso getSecondsFromStartOfDay()
	public boolean equals(Object other) {
		// completate
	}

	// non banale
	public int hashCode() {
		// completate
	}

	public Interval interval(int howManySeconds) {
		return new Interval(??????????????); // completate
	}
}
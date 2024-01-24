package it.univr.agenda;

/**
 * Un momento temporale della giornata. Gli oggetti Time sono
 * ordinati per ordine cronologico.
 */
public abstract class Time implements Comparable<Time> {

	/**
	 * I secondi passati dall'inizio della giornata
	 */
	protected final int secondsFromStartOfDay;

	/**
	 * Costruttore.
	 * 
	 * @param secondsFromStartOfDay i secondi passati dall'inizio della giornata
	 */
	protected Time(int secondsFromStartOfDay) {
		this.secondsFromStartOfDay = secondsFromStartOfDay;
	}

	/**
	 * Restituisce l'istante temporale minutes minuti dopo questo
	 * 
	 * @param minutes i minuti di differenza fra questo e il risultato
	 * @return l'istante risultante aggiungendo minutes minuti a questo
	 * @throws IllegalArgumentException se minutes fosse negativo
	 */
	public abstract Time after(int minutes);

	/**
	 * Determina se questo istante viene prima o coincide con other.
	 * 
	 * @param other l'altro istante da confrontare con this
	 */
	public boolean isBeforeOrEqualTo(Time other) {
		return compareTo(other) <= 0;
	}

	/**
	 * Due Time sono uguali se rappresentano lo stesso istante del giorno.
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof Time && ((Time) other).secondsFromStartOfDay == secondsFromStartOfDay;
	}

	@Override
	public int hashCode() {
		return secondsFromStartOfDay;
	}

	@Override
	public int compareTo(Time other) {
		return secondsFromStartOfDay - other.secondsFromStartOfDay;
	}

	public abstract String toString();
}
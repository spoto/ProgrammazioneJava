package it.univr.agenda;

// Ci sono 4 TODO

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
		return false; //TODO
	}

	/**
	 * Due Time sono uguali se rappresentano lo stesso istante del giorno.
	 */
	@Override
	public boolean equals(Object other) {
		return false; // TODO
	}

	@Override
	public int hashCode() {
		return 0; //TODO, non banale!
	}

	@Override
	public int compareTo(Time other) {
		return 0; // TODO
	}

	public abstract String toString();
}
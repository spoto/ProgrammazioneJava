package it.univr.agenda;

// Ci sono 5 TODO

/**
 * Un evento della giornata, con un nome, un momento di inizio e una durata.
 * Gli eventi sono ordinati per momento di inizio. A parita' di momento di
 * inizio, sono ordinati per nome dell'evento.
 */
public class Event implements Comparable<Event> {

	/**
	 * Il nome dell'evento.
	 */
	private final String name;

	/**
	 * L'inizio dell'evento.
	 */
	private final Time start;

	/**
	 * La durata dell'evento, in minuti.
	 */
	private final int durationInMinutes;

	public Event(String name, Time start, int durationInMinutes) {
		this.name = name;
		this.start = start;
		this.durationInMinutes = durationInMinutes;
	}

	/**
	 * Il momento di fine dell'evento.
	 * 
	 * @return durationInMinutes minuti dopo start
	 */
	public Time endTime() {
		return null; //TODO
	}

	@Override
	public int compareTo(Event other) {
		return 0; //TODO
	}

	/**
	 * Due eventi sono uguali se hanno stesso nome e stesso momento di inizio (la durata non si considera).
	 */
	@Override
	public boolean equals(Object other) {
		return false; //TODO
	}

	@Override
	public int hashCode() {
		return 0; //TODO, non banale!
	}

	/**
	 * Determina se questo evento e' sovrapposto temporalmente (in tutto o in parte) con un altro evento.
	 * 
	 * @param other l'altro evento
	 */
	public boolean overlapsWith(Event other) {
		return false; //TODO
	}

	@Override
	public String toString() {
		return name + "@" + start + " for " + durationInMinutes + " minutes";
	}
}
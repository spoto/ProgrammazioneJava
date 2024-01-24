package it.univr.agenda;

// Ci sono 5 TODO

/**
 * Un evento, con un nome, una data di inizio e una durata in giorni.
 * Gli eventi sono ordinati per data di inizio. A parita' di data di
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
	private final Date start;

	/**
	 * La durata dell'evento, in giorni.
	 */
	private final int durationInDays;

	public Event(String name, Date start, int durationInDays) {
		this.name = name;
		this.start = start;
		this.durationInDays = durationInDays;
	}

	/**
	 * Il giorno di fine dell'evento.
	 * 
	 * @return durationInDays giorni dopo start
	 */
	private Date endDate() {
		return null; // TODO
	}

	@Override
	public int compareTo(Event other) {
		return 0; // TODO
	}

	/**
	 * Due eventi sono uguali se hanno stesso nome e stessa data di inizio (la durata non si considera).
	 */
	@Override
	public boolean equals(Object other) {
		return false; // TODO
	}

	@Override
	public int hashCode() {
		return 0; // TODO, non banale!
	}

	/**
	 * Determina se questo evento e' sovrapposto temporalmente (in tutto o in parte) con un altro evento.
	 * 
	 * @param other l'altro evento
	 */
	public boolean overlapsWith(Event other) {
		return false; // TODO
	}

	@Override
	public String toString() {
		return name + "@" + start + " for " + durationInDays + " days";
	}
}
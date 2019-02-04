package it.univr.agenda;

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
		return start.after(durationInDays);
	}

	@Override
	public int compareTo(Event other) {
		int diff = start.compareTo(other.start);
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.name);
	}

	/**
	 * Due eventi sono uguali se hanno stesso nome e stessa data di inizio (la durata non si considera).
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof Event && start.equals(((Event) other).start) && name.equals(((Event) other).name);
	}

	@Override
	public int hashCode() {
		return start.hashCode() ^ name.hashCode();
	}

	/**
	 * Determina se questo evento e' sovrapposto temporalmente (in tutto o in parte) con un altro evento.
	 * 
	 * @param other l'altro evento
	 */
	public boolean overlapsWith(Event other) {
		return !(endDate().isBeforeOrEqualTo(other.start) || other.endDate().isBeforeOrEqualTo(start));
	}

	@Override
	public String toString() {
		return name + "@" + start + " for " + durationInDays + " days";
	}
}
package it.univr.agenda;

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
		return start.after(durationInMinutes);
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
	 * Due eventi sono uguali se hanno stesso nome e stesso momento di inizio (la durata non si considera).
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
		return !(endTime().isBeforeOrEqualTo(other.start) || other.endTime().isBeforeOrEqualTo(start));
	}

	@Override
	public String toString() {
		return name + "@" + start + " for " + durationInMinutes + " minutes";
	}
}
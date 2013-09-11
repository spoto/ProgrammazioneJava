package it.univr.calendar;

public abstract class Event implements Comparable<Event> {

	private final Time startingTime;

	private final String name;

	protected Event(Time startingTime, String name) {
		this.startingTime = startingTime;
		this.name = name;
	}

	public abstract void delete();

	@Override
	public final String toString() {
		return name + " @ " + startingTime;
	}

	@Override
	public final int compareTo(Event other) {
		int result = startingTime.compareTo(other.startingTime);
		if (result == 0)
			result = name.compareTo(other.name);

		return result;
	}

	@Override
	public final boolean equals(Object other) {
		return other instanceof Event && ((Event) other).startingTime.equals(startingTime)
			&& ((Event) other).name.equals(name);
	}

	@Override
	public final int hashCode() {
		return startingTime.hashCode() ^ name.hashCode();
	}
}
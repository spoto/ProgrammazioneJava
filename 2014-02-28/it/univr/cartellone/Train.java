package it.univr.cartellone;

public class Train implements Comparable<Train> {
	private final Time time;
	private final int number;
	private final String destination;

	public Train(Time time, int number, String destination) {
		this.time = time;
		this.number = number;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return String.format("%s : treno %d per %s", time.toStringOnlyHour(), number, destination);
	}

	@Override
	public int compareTo(Train other) {
		int diff = time.compareTo(other.time);
		if (diff != 0)
			return diff;

		// a parità di orario di partenza, li ordiniamo per numero di treno crescente
		return number - other.number;
	}
}
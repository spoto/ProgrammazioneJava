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
		else
			return number - other.number;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Train) {
			Train otherAsTrain = (Train) other;
			return time.equals(otherAsTrain.time)
				&& number == otherAsTrain.number;
		}
		else
			return false;
	}
}
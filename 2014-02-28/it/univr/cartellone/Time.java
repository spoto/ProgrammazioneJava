package it.univr.cartellone;

public class Time implements Comparable<Time> {
	private final int minutes;
	private final int hours;
	private final int day;
	private final int month;
	private final int year;

	public Time(int year, int month, int day, int hours, int minutes) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hours = hours;
		this.minutes = minutes;
	}

	@Override
	public int compareTo(Time other) {
		int diff = year - other.year;
		if (diff != 0)
			return diff;

		diff = month - other.month;
		if (diff != 0)
			return diff;

		diff = day - other.day;
		if (diff != 0)
			return diff;

		diff = hours - other.hours;
		if (diff != 0)
			return diff;

		return minutes - other.minutes;
	}

	public String toStringOnlyHour() {
		String h = hours >= 10 ? String.valueOf(hours) : ("0" + hours);
		String m = minutes >= 10 ? String.valueOf(minutes) : ("0" + minutes);

		return String.format("%s:%s", h, m);
	}
}
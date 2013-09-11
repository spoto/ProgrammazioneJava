package it.univr.calendar;

public class Time implements Comparable<Time> {

	private final int year;
	private final int month;
	private final int day;
	private final int hour;
	private final int minute;

	public Time(int year, int month, int day, int hour, int minute) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year + ", " + hour + ":"
				+ (minute < 10 ? ("0" + minute) : minute);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Time) {
			Time otherTime = (Time) other;

			return year == otherTime.year && month == otherTime.month
				&& day == otherTime.day && hour == otherTime.hour && minute == otherTime.minute;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return year ^ month ^ day ^ hour ^ minute;
	}

	@Override
	public int compareTo(Time other) {
		int diff = year - other.year;
		if (diff != 0)
			return diff;

		if ((diff = month - other.month) != 0)
			return diff;
		else if ((diff = day - other.day) != 0)
			return diff;
		else if ((diff = hour - other.hour) != 0)
			return diff;
		else
			return minute - other.minute;
	}
}
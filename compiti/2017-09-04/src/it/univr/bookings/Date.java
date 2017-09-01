package it.univr.bookings;

public class Date implements Comparable<Date> {
	private final int day, month, year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Date) {
			Date otherAsDate = (Date) other;
			return otherAsDate.day == day && otherAsDate.month == month && otherAsDate.year == year;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return day ^ month ^ year;
	}

	@Override
	public int compareTo(Date other) {
		int diff = day - other.day;
		if (diff != 0)
			return diff;

		diff = month - other.month;
		if (diff != 0)
			return diff;

		return year - other.year;
	}

	@Override
	public String toString() {
		return String.format("%2d/%2d/%4d", day, month, year);
	}

	public boolean isXmas() {
		return day == 25 && month == 12;
	}

	public boolean isNewYearsEve() {
		return day == 31 && month == 12;
	}

	public boolean isThanksgiving() {
		return day == 23 && month == 11;
	}

	public boolean isAllSaintsDay() {
		return day ==1 && month == 11;
	}

	public boolean isColumbusDay() {
		return day == 9 && month == 10;
	}

	public boolean isLincolnBirthday() {
		return day == 12 && month == 2;
	}
}
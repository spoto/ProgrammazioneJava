public class Time implements Comparable<Time> {
	private final int year;
	private final int month;
	private final int day;
	private final int hours;
	private final int minutes;

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
		return String.format("%02d:%02d", hours, minutes);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Time) {
			Time otherAsTime = (Time) other;
			return year == otherAsTime.year
				&& month == otherAsTime.month
				&& day == otherAsTime.day
				&& hours == otherAsTime.hours
				&& minutes == otherAsTime.minutes;
		}
		else
			return false;
	}
}
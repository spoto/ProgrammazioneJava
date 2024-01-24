package it.univr.doodle;

public class Slot implements Comparable<Slot> {
	private final int year;
	private final int month;
	private final int day;
	private final Moment moment;

	public Slot(int year, int month, int day, Moment moment) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.moment = moment;
	}

	public int compareTo(Slot other) {
		int diff = year - other.year;
		if (diff != 0)
			return diff;
		
		diff = month - other.month;
		if (diff != 0)
			return diff;
		
		diff = day - other.day;
		if (diff != 0)
			return diff;
		
		return moment.compareTo(other.moment);
	}

	public boolean equals(Object other) {
		if (other instanceof Slot) {
			Slot otherAsSlot = (Slot) other;
			return year == otherAsSlot.year
				&& month == otherAsSlot.month
				&& day == otherAsSlot.day
				&& moment == otherAsSlot.moment;
		}
		else
			return false;
	}

	public int hashCode() {
		return year ^ month ^ day ^ moment.hashCode();
	}

	public String toString() {
		return day + "/" + month + "/" + year + " " + moment;
	}

	// le enum sono sempre comparabili, quindi
	// hanno un metodo compareTo, inserito dal compilatore;
	// inoltre hanno dei metodi equals e hashCode correttamente
	// definiti dal compilatore
	public enum Moment {
		MORNING,
		AFTERNOON,
		EVENING,
		NIGHT
	}
}


public class Hour {
	// campi o fields
	// private significa che i campi hour e minutes
	// si possono nominare solo dentro questa classe
	private int hour;
	private int minutes;

	// costruttori
	// public significa che questo metodo si può nominare
	// in qualsiasi punto del programma
	public Hour(int hour, int minutes) {
		this.hour = hour;
		this.minutes = minutes;
	}

	public Hour(int hour) {
		this.hour = hour;
		minutes = 0;
	}

	public Hour() {	
	}

	// copy constructor
	public Hour(Hour parent) {
		this.hour = parent.hour;
		this.minutes = parent.minutes;
	}

	// restituisce una descrizione stringa stampabile
	// dell'oggetto
	public String toString() {
		String hourAsString = add0IfNeeded(hour);
		String minutesAsString = add0IfNeeded(minutes);
		return hourAsString + ":" + minutesAsString;
	}

	private String add0IfNeeded(int i) {
		return i < 10 ? "0"	+ i : "" + i;
	}

	public boolean equals(Hour other) {
		return hour == other.hour && minutes == other.minutes;
	}
	
	// ha effetti secondari
	// side-effects
	public void tick() {
		if (++minutes == 60) {
			minutes = 0;
			if (++hour == 24)
				hour = 0;
		}
	}
}




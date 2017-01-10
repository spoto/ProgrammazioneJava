// Voglio potere utilizzare questa classe
// sia negli HashSet che nei TreeSet

public class Person implements Comparable<Person> {
	private final String name;
	private final String surname;
	private final int day;
	private final int month;
	private final int year;
	
	public Person(String name, String surname,
			int day, int month, int year) {
		this.name = name;
		this.surname = surname;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		return name + " " + surname + " (" +
			day + "/" + month + "/" + year + ")";
	}
	
	public boolean equals(Object other) {
		if (other instanceof Person) {
			Person otherAP = (Person) other;
			return name.equals(otherAP.name)
				&& surname.equals(otherAP.surname)
				&& day == otherAP.day
				&& month == otherAP.month
				&& year == otherAP.year;
		}
		else
			return false;
	}

	public int hashCode() {
		// corretta ma con pessima distribuzione
		return name.hashCode() ^ surname.hashCode()
				^ day ^ month ^ year;
	}

	public int compareTo(Person other) {
		// metto in ordine per cognome, nome, anno, mese giorno
		int diff = surname.compareTo(other.surname);
		if (diff != 0)
			return diff;
		
		diff = name.compareTo(other.name);
		if (diff != 0)
			return diff;
		
		diff = year - other.year;
		if (diff != 0)
			return diff;
		
		diff = month - other.month;
		if (diff != 0)
			return diff;
		
		return day - other.day;
	}
}


public class Person {
	private String name;
	private String surname;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String toString() {
		return name + " " + surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	/**
	 * Mette in ordine per cognome e poi per nome.
	 */
	public int compareTo(Person other) {
		int diff = surname.compareTo(other.surname);
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.name);
	}



}


public class Student extends Person {
	// vengono "ricopiati" tutti i campi
	// e i metodi di Person
	
	private int code;

	public Student(String name, String surname, int code) {
		super(name, surname);

		this.code = code; // matricola
	}

	public String toString() {
		return super.toString()
			+ " registration number: " + code;
	}
}

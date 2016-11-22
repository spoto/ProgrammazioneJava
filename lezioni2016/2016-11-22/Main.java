
public class Main {

	public static void main(String[] args) {
		// tipo statico = Person
		// tipo dinamico = Person
		Person p1 = new Person("Fausto", "Spoto");
		Person p2 = new Person("Giorgio", "Levi");
		Person p3 = new Person("Guido", "Spoto");
		Person p4 = new Person("Giorgio", "De Alessandro");

		// tipo statico = Person
		// tipo dinamico = Student
		Person s1 = new Student("Roberto", "Baggio", 131515);
		Person s2 = new Student("Sofia", "Loren", 98788);

		// tipo statico = Student
		// tipo dinamico = Student
		Student s3 = new Student("Roberto", "Giacobazzi", 11122);

		Person[] arr = { p1, p2, p3, p4, s1, s2, s3 };
		sort(arr);
		print(arr);

		// le chiamate avvengono sulla base del tipo dinamico
	}

	private static void print(Person[] people) {
		for (Person person: people)
			System.out.println(person.toString());
	}

	private static void sort(Person[] people) {
		while (swap(people));
	}

	private static boolean swap(Person[] people) {
		boolean done = false;
		for (int pos = 0; pos < people.length - 1; pos++)
			if (people[pos].compareTo(people[pos + 1]) > 0) {
				Person temp = people[pos];
				people[pos] = people[pos + 1];
				people[pos + 1] = temp;
				done = true;
			}

		return done;
	}
	
	
	
	
	
	
	
}

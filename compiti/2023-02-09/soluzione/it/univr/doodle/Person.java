package it.univr.doodle;

public abstract class Person implements Comparable<Person> {
	private final String name;
	
	protected Person(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	public abstract int priority();

	public int compareTo(Person other) {
		int diff = priority() - other.priority();
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.name);
	}

	public boolean equals(Object other) {
		return other instanceof Person &&
			name.equals(((Person) other).name) &&
			priority() == ((Person) other).priority();
	}
}
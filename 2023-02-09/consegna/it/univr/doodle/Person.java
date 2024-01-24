package it.univr.doodle;

// si renda questa classe comparabile con un'altra Person:
// ordinando prima per priorita' crescente e poi alfabeticamente per nome
// nota: dovrete aggiungere un metodo public: quale?
public abstract class Person {
	private final String name;
	
	protected Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ""; // deve restituire il nome
	}
	
	public abstract int priority();

	public boolean equals(Object other) {
		return false; // devono avere stesso nome e stessa priorità
	}
}

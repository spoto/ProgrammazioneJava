package it.univr.circuit;

public class Variable extends Circuit {

	private final String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean isTrueIn(Assignment assignment) {
		return assignment.valueOf(this);
	}

	@Override
	public Variable[] freeVariables() {
		return new Variable[] { this };
	}
}







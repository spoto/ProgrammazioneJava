package it.univr.circuit;

public class Not extends Circuit {

	private final Circuit negated;

	public Not(Circuit negated) {
		this.negated = negated;
	}

	@Override
	public String toString() {
		return "not(" + negated + ")";
	}

	@Override
	public boolean isTrueIn(Assignment assignment) {
		return !negated.isTrueIn(assignment);
	}

	@Override
	public Variable[] freeVariables() {
		return negated.freeVariables();
	}
}
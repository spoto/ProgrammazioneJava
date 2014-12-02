package it.univr.circuit;

public class And extends BinOp {

	public And(Circuit left, Circuit right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return "and(" + getLeft() + "," + getRight() + ")";
	}

	@Override
	public boolean isTrueIn(Assignment assignment) {
		return getLeft().isTrueIn(assignment) && getRight().isTrueIn(assignment);
	}
}
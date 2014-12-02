package it.univr.circuit;

public class Or extends BinOp {

	public Or(Circuit left, Circuit right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return "or(" + getLeft() + "," + getRight() + ")";
	}

	@Override
	public boolean isTrueIn(Assignment assignment) {
		return getLeft().isTrueIn(assignment) || getRight().isTrueIn(assignment);
	}
}













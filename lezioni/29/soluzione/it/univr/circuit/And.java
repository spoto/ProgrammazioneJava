package it.univr.circuit;

public class And extends Circuit {

	private final Circuit left;
	private final Circuit right;

	public And(Circuit left, Circuit right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "and(" + left + "," + right + ")";
	}

	@Override
	public boolean isTrueIn(Assignment assignment) {
		return left.isTrueIn(assignment) && right.isTrueIn(assignment);
	}

	@Override
	public Variable[] freeVariables() {
		Variable[] fvLeft = left.freeVariables();
		Variable[] fvRight = right.freeVariables();

		return merge(fvLeft, fvRight);
	}

	private static Variable[] merge(Variable[] fvLeft, Variable[] fvRight) {
		Variable[] fv = new Variable[fvLeft.length + fvRight.length];
		int pos = 0;

		for (Variable v: fvLeft)
			fv[pos++] = v;

		for (Variable v: fvRight)
			if (!contains(fvLeft, v))
				fv[pos++] = v;

		// scartiamo eventuali elementi in più, rimasti a null
		Variable[] res = new Variable[pos];
		for (Variable v: fv)
			if (v != null)
				res[--pos] = v;

		return res;
	}

	private static boolean contains(Variable[] vars, Variable var) {
		for (Variable v: vars)
			if (v.getName().equals(var.getName()))
				return true;

		return false;
	}
}
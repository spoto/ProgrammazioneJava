package it.univr.spreadsheet;

import java.util.HashSet;
import java.util.Set;

public class Append extends Exp {

	private final Exp left, right;

	public Append(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	protected int getNumericValue(Set<Cell> seen) throws EvaluationException {
		throw new EvaluationException("the value of append is not numeric");
	}

	@Override
	protected String getStringValue(Set<Cell> seen) throws EvaluationException {
		return left.getStringValue(new HashSet<Cell>(seen)) + " " + right.getStringValue(new HashSet<Cell>(seen));
	}
}
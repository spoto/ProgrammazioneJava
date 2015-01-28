package it.univr.spreadsheet;

import java.util.HashSet;
import java.util.Set;

public class Add extends Exp {

	private final Exp left, right;

	public Add(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	protected int getNumericValue(Set<Cell> seen) throws EvaluationException {
		return left.getNumericValue(new HashSet<Cell>(seen)) + right.getNumericValue(new HashSet<Cell>(seen));
	}

	@Override
	protected String getStringValue(Set<Cell> seen) throws EvaluationException {
		return String.valueOf(getNumericValue(seen));
	}
}
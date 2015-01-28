package it.univr.spreadsheet;

import java.util.Set;

public class NumericConstant extends Exp {

	private final int value;

	public NumericConstant(int value) {
		this.value = value;
	}

	@Override
	protected int getNumericValue(Set<Cell> seen) throws EvaluationException {
		return value;
	}

	@Override
	protected String getStringValue(Set<Cell> seen) throws EvaluationException {
		return String.valueOf(getNumericValue(seen));
	}
}
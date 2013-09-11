package it.univr.spreadsheet;

import java.util.Set;

public class StringConstant extends Exp {

	private final String value;

	public StringConstant(String value) {
		this.value = value;
	}

	@Override
	protected int getNumericValue(Set<Cell> seen) throws EvaluationException {
		throw new EvaluationException(value + " is not numeric");
	}

	@Override
	protected String getStringValue(Set<Cell> seen) throws EvaluationException {
		return value;
	}
}
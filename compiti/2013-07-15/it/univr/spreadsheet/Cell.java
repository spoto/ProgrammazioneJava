package it.univr.spreadsheet;

import java.util.Set;

public final class Cell extends Exp {
	private Exp exp;

	protected Cell() {
		this.exp = new StringConstant("");
	}

	public void setExp(Exp exp) {
		this.exp = exp;
	}

	@Override
	protected int getNumericValue(Set<Cell> seen) throws EvaluationException {
		if (!seen.add(this))
			throw new CyclicEvaluationException();

		return exp.getNumericValue(seen);
	}

	@Override
	protected String getStringValue(Set<Cell> seen) throws EvaluationException {
		if (!seen.add(this))
			throw new CyclicEvaluationException();

		return exp.getStringValue(seen);
	}
}
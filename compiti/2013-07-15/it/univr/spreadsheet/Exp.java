package it.univr.spreadsheet;

import java.util.HashSet;
import java.util.Set;

public abstract class Exp {
	public final int getNumericValue() throws EvaluationException {
		return getNumericValue(new HashSet<Cell>());
	}

	protected abstract int getNumericValue(Set<Cell> seen) throws EvaluationException;

	public final String getStringValue() throws EvaluationException {
		return getStringValue(new HashSet<Cell>());
	}

	protected abstract String getStringValue(Set<Cell> seen) throws EvaluationException;

	@Override
	public final String toString() {
		try {
			return getStringValue();
		}
		catch (CyclicEvaluationException e) {
			return "@@@";
		}
		catch (EvaluationException e) {
			return "###";
		}
	}
}

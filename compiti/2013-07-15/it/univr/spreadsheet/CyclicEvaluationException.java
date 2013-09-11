package it.univr.spreadsheet;

public class CyclicEvaluationException extends EvaluationException {
	public CyclicEvaluationException() {
		super("the evaluation went into a loop");
	}
}

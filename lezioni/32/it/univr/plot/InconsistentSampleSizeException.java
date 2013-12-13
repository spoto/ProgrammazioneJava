package it.univr.plot;

public class InconsistentSampleSizeException extends Exception {

	public InconsistentSampleSizeException() {
		super("samples must have the same size inside a plot");
	}

	public InconsistentSampleSizeException(String message) {
		super(message);
	}
}
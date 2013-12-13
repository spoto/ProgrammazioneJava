package it.univr.plot;

public class DuplicatedSampleException extends Exception {

	public DuplicatedSampleException() {
		super("trying to add a sample with the same name");
	}

	public DuplicatedSampleException(String message) {
		super(message);
	}
}
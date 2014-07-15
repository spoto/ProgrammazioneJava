package it.univr.identifiers;

public class EmptyWordException extends IllegalArgumentException {

	public EmptyWordException() {
		super("An empty word has been provided");
	}
}

package it.univr.identifiers;

public class NegativeProgressiveNumberException extends IllegalArgumentException {

	public NegativeProgressiveNumberException(int num) {
		super("Negative progressive nmber provided: " + num);
	}
}

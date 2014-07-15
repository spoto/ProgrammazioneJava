package it.univr.identifiers;

public class NoWordsProvidedException extends IllegalArgumentException {

	public NoWordsProvidedException() {
		super("No word has been specified");
	}
}

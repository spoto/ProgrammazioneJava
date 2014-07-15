package it.univr.identifiers;

public class WordIsNotAlphabeticalLowercaseException extends IllegalArgumentException {

	public WordIsNotAlphabeticalLowercaseException(String word) {
		super("Word " + word + " contains a non-lowercase or non-alphabetical word");
	}
}

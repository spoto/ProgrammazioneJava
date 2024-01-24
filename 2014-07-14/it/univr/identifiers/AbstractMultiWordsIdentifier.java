package it.univr.identifiers;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMultiWordsIdentifier implements Identifier {

	private final String[] words;

	// Fallisce con un'eccezione
	// se non c'e' alcuna parola o se c'e' una parola vuota o se una
	// parola contiene un carattere non alfabetico minuscolo
	protected AbstractMultiWordsIdentifier(String... words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		if (words.length == 0)
			throw new NoWordsProvidedException();

		for (String word: words)
			if (word.isEmpty())
				throw new EmptyWordException();
			else if (!isAlphabeticalLowercase(word))
				throw new WordIsNotAlphabeticalLowercaseException(word);

		this.words = words;
	}

	private boolean isAlphabeticalLowercase(String word) {
		char c;

		for (int pos = 0; pos < word.length(); pos++)
			if (!Character.isAlphabetic(c = word.charAt(pos)) || !Character.isLowerCase(c))
				return false;

		return true;
	}

	// Fallisce con un'eccezione nelle stesse condizioni viste sopra
	protected AbstractMultiWordsIdentifier(Iterable<String> words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		this(intoArray(words));
	}

	private static String[] intoArray(Iterable<String> words) {
		List<String> list = new ArrayList<String>();
		for (String word: words)
			list.add(word);

		return list.toArray(new String[list.size()]);
	}

	// restituisce le parole fornite al momento della costruzione di questo Formatter
	protected final String[] getWords() {
		return words;
	}
}
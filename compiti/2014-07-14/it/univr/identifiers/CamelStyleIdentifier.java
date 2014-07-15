package it.univr.identifiers;

public class CamelStyleIdentifier extends AbstractMultiWordsIdentifier {

	public CamelStyleIdentifier(String... words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		super(words);
	}

	public CamelStyleIdentifier(Iterable<String> words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		super(words);
	}

	@Override
	public String toString() {
		String result = "";
		for (String word: getWords())
			result += Character.toUpperCase(word.charAt(0)) + word.substring(1);

		return result;
	}
}
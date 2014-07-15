package it.univr.identifiers;

public class SnakeStyleIdentifier extends AbstractMultiWordsIdentifier {

	public SnakeStyleIdentifier(String... words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		super(words);
	}

	public SnakeStyleIdentifier(Iterable<String> words) throws NoWordsProvidedException, WordIsNotAlphabeticalLowercaseException, EmptyWordException {
		super(words);
	}

	@Override
	public String toString() {
		String result = "";
		for (String word: getWords())
			result += word + "_";

		return result.substring(0, result.length() - 1);
	}
}
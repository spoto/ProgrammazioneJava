package it.univr.identifiers;

import java.util.ArrayList;
import java.util.List;

// un identificatore fatto da piu' parole in sequenza
public abstract class MultiWordIdentifier implements Identifier {

	private final String[] words;

	// fallisce con una IllegalArgumentException se non c'e' nessuna parola
	// o se c'e' una parola null oppure vuota
	// o se una parola contiene un carattere non alfabetico
	protected MultiWordIdentifier(String... words) throws IllegalArgumentException {
		if (words.length == 0)
			throw new IllegalArgumentException("a multiword identifier needs at least one word");

		for (String word: words)
			if (word == null || word.isEmpty())
				throw new IllegalArgumentException("a word cannot be null or empty");
			else if (!isAlphabetic(word))
				throw new IllegalArgumentException(word + " is not alphabetic");

		this.words = words;
	}

	// fallisce con un'eccezione nelle stesse condizioni viste sopra
	protected MultiWordIdentifier(Iterable<String> words) throws IllegalArgumentException {
		this(intoArray(words));
	}

	@Override
	public final String toString() {
		String result = "";
		for (int pos = 0; pos < words.length; pos++)
			// sottoclassi diverse forniscono implementazioni diverse di toString(pos, words[pos])
			result += toString(pos, words[pos]);
	
		return result;
	}

	// restituisce la stringa che descrive la componente pos-esima dell'identificatore
	protected abstract String toString(int pos, String word);

	// restituisce la concatenazione delle parole degli identificatori indicati
	protected static List<String> concat(MultiWordIdentifier... ids) {
		List<String> result = new ArrayList<>();
		for (MultiWordIdentifier id: ids)
			for (String s: id.words)
				result.add(s);
		
		return result;
	}

	private static boolean isAlphabetic(String word) {
		// oppure con un ciclo for
		return word.chars().allMatch(Character::isAlphabetic);
	}

	private static String[] intoArray(Iterable<String> words) {
		List<String> list = new ArrayList<>();
		for (String word: words)
			list.add(word);

		return list.toArray(new String[list.size()]);
	}
}
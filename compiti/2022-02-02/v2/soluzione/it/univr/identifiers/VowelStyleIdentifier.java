package it.univr.identifiers;

public class VowelStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore vowel-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public VowelStyleIdentifier(String... words) {
		super(words);
	}

	// come sopra
	public VowelStyleIdentifier(Iterable<String> words) {
		super(words);
	}

	// costruisce un identificatore vowel-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public VowelStyleIdentifier(MultiWordIdentifier... ids) {
		super(concat(ids));
	}

	// restituisce un identificatore snake-style con le stesse parole di this
	public SnakeStyleIdentifier toSnakeStyle() {
		return new SnakeStyleIdentifier(this);
	}

	@Override
	protected String toString(int pos, String word) {
		String result = "";

		for (int i = 0; i < word.length(); i++)
			if ("aeiouAEIOU".indexOf(word.charAt(i)) >= 0)
				result += Character.toUpperCase(word.charAt(i));
			else
				result += Character.toLowerCase(word.charAt(i));

		return result;
	}
}
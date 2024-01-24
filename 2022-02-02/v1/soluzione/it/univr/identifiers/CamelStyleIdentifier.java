package it.univr.identifiers;

public class CamelStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore camel-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public CamelStyleIdentifier(String... words) {
		super(words);
	}

	// come sopra
	public CamelStyleIdentifier(Iterable<String> words) {
		super(words);
	}

	// costruisce un identificatore camel-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public CamelStyleIdentifier(MultiWordIdentifier... ids) {
		super(concat(ids));
	}

	// restituisce un identificatore snake-style con le stesse parole di this
	public SnakeStyleIdentifier toSnakeStyle() {
		return new SnakeStyleIdentifier(this);
	}

	@Override
	protected String toString(int pos, String word) {
		if (pos == 0)
			return word.toLowerCase();
		else
			return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
	}
}
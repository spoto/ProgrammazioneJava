package it.univr.identifiers;

//TODO: fate compilare questa classe

public class SnakeStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore snake-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public SnakeStyleIdentifier(String... words) {
		// TODO
	}

	// come sopra
	public SnakeStyleIdentifier(Iterable<String> words) {
		// TODO
	}

	// costruisce un identificatore snake-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public SnakeStyleIdentifier(MultiWordIdentifier... ids) {
		// TODO
	}

	// restituisce un identificatore vowel-style con le stesse parole di this
	public VowelStyleIdentifier toVowelStyle() {
		// TODO
		return null;
	}
}
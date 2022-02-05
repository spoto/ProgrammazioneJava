package it.univr.identifiers;

// TODO: fate compilare questa classe

public class CamelStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore camel-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public CamelStyleIdentifier(String... words) {
		// TODO
	}

	// come sopra
	public CamelStyleIdentifier(Iterable<String> words) {
		// TODO
	}

	// costruisce un identificatore camel-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public CamelStyleIdentifier(MultiWordIdentifier... ids) {
		// TODO
	}

	// restituisce un identificatore snake-style con le stesse parole di this
	public SnakeStyleIdentifier toSnakeStyle() {
		// TODO
		return null;
	}
}
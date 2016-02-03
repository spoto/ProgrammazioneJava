package it.univr.elezioni;

public enum Partito {
	PENSIONATI,
	FELICE,
	FLOREALE,
	CAOTICO,
	BASSOTTI;

	public final static int NUMERO_PARTITI = elementi().length;

	public static Partito[] elementi() {
		return values();
	}

	public int indice() {
		for (int pos = 0; pos < NUMERO_PARTITI; pos++)
			if (elementi()[pos] == this)
				return pos;

		throw new RuntimeException("impossibile");
	}
}
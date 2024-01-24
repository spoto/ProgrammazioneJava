package it.univr.quindici;

public class FattoriaDiTessereNumeriche extends FattoriaDiTessere<Integer> {
	private final int max;

	public FattoriaDiTessereNumeriche(int max) {
		this.max = max;
	}

	// generiamo una tessera numerica contenente un numero casuale tra 1 e max inclusi
	public Tessera<Integer> get() {
		return new Tessera<>(1 + random.nextInt(max));
	}
}
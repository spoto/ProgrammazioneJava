package it.univr.quindici;

public class FattoriaDiTessereAlfabetiche extends FattoriaDiTessere<String> {

	public Tessera<String> get() {
		// generiamo una stringa casuale lunga da 1 a 5 caratteri
		int len = 1 + random.nextInt(5);
		String s = "";
		while (len-- > 0)
			s += (char) ('a' + random.nextInt(26));

		return new Tessera<>(s);
	}
}
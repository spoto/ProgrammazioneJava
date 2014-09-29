package it.univr.quindici;

import java.util.Random;

public class FattoriaDiTessereAlfabetiche implements FattoriaDiTessere {
	private final static Random random = new Random();

	@Override
	public Tessera mkRandom() {
		return new TesseraAlfabetica(stringaRandom());
	}

	private final static String stringaRandom() {
		int len = 1 + random.nextInt(5);
		String s = "";
		while (len-- > 0)
			s += (char) ('a' + random.nextInt(26));

		return s;
	}
}
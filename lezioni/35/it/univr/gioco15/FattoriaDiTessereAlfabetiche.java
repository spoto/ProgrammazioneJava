package it.univr.gioco15;

import java.util.Random;

public class FattoriaDiTessereAlfabetiche implements FattoriaDiTessere {

	public FattoriaDiTessereAlfabetiche() {
	}

	private final static Random random = new Random();

	@Override
	public Tessera mkRandom() {
		return new TesseraAlfabetica(nomeCasuale());
	}

	private String nomeCasuale() {
		String result = "";

		int length = random.nextInt(5) + 1;
		for (int pos = 0; pos < length; pos++)
			result += (char) ('a' + random.nextInt(26));

		return result;
	}
}
package it.univr.gioco15;

import java.util.Random;

public class FattoriaDiTessereAlfabetiche implements FattoriaDiTessere {
	public FattoriaDiTessereAlfabetiche() {
	}

	@Override
	public Tessera mkRandom() {
		// genera una stringa s a casa di lunghezza fra 1 e 5 a caso
		int len = 1 + random.nextInt(5);
		String s = "";
		
		for (int i = 1; i <= len; i++)
			s += (char) ('a' + random.nextInt(26));

		return new TesseraAlfabetica(s);
	}

	private final static Random random = new Random();
}

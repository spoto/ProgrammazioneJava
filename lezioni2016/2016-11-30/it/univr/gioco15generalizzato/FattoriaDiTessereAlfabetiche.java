package it.univr.gioco15generalizzato;

import java.util.Random;

public class FattoriaDiTessereAlfabetiche implements FattoriaDiTessere {
	private final static Random random = new Random();

	public Tessera mkRandom() {
		int len = random.nextInt(5) + 1;
		String s = "";
		
		while (len-- > 0)
			s += (char) ('a' + random.nextInt(26));

		return new TesseraAlfabetica(s);
	}
}

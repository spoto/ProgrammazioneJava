package it.univr.gioco15generalizzato;

import java.util.Random;

public class FattoriaDiTessereNumeriche implements FattoriaDiTessere {
	private final static Random random = new Random();
	private final int max;

	public FattoriaDiTessereNumeriche(int max) {
		this.max = max;
	}

	public Tessera mkRandom() {
		return new TesseraNumerica(random.nextInt(max) + 1);
	}
}

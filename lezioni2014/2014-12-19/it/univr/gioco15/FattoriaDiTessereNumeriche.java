package it.univr.gioco15;

import java.util.Random;

public class FattoriaDiTessereNumeriche implements FattoriaDiTessere {
	private final int max;

	public FattoriaDiTessereNumeriche(int max) {
		this.max = max;
	}

	@Override
	public Tessera mkRandom() {
		return new TesseraNumerica(1 + random.nextInt(max));
	}

	private final static Random random = new Random();
}

package it.univr.quindici;

import java.util.Random;

public class FattoriaDiTessereNumeriche implements FattoriaDiTessere {
	private final static Random random = new Random();
	private final int max;

	public FattoriaDiTessereNumeriche(int max) {
		this.max = max;
	}

	@Override
	public Tessera mkRandom() {
		return new TesseraNumerica(1 + random.nextInt(max));
	}
}
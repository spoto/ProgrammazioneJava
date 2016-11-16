package it.univr.gioco15;

import java.util.Random;

public class Gioco15 {
	private final int[][] caselle = new int[4][4];
	private final static Random random = new Random();
	
	public Gioco15() {
		for (int value = 1; value <= 15; value++)
			posizionaInCasellaRandomVuota(value);
	}

	private void posizionaInCasellaRandomVuota(int value) {
		int x, y;
		do {
			x = random.nextInt(4);
			y = random.nextInt(4);
		}
		// continua a generare coordinate finché non le trova vuote
		while (caselle[x][y] != 0);

		caselle[x][y] = value;
	}

	public String toString() {
		String result = "";
		for (int riga = 0; riga < 4; riga++)
			result += String.format("%3s%3s%3s%3s\n",
					caselle[riga][0],
					caselle[riga][1],
					caselle[riga][2],
					caselle[riga][3]);

		result = result.replace("  0", "   ");

		return result;
	}

	public void sposta(int x, int y) {
		//TODO
	}
}

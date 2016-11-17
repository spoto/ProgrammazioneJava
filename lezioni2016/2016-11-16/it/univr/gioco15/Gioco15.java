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
		for (int[] riga: caselle)
			result += String.format("%3s%3s%3s%3s\n",
					riga[0],
					riga[1],
					riga[2],
					riga[3]);

		result = result.replace("  0", "   ");

		return result;
	}

	public void sposta(int x, int y) {
		spostaSinistra(x, y);
		spostaDestra(x, y);
		spostaSopra(x, y);
		spostaSotto(x, y);
	}

	private void spostaSotto(int riga, int colonna) {
		if (caselle[riga][colonna] != 0 && riga != 3) {
			spostaSotto(riga + 1, colonna);
			if (caselle[riga + 1][colonna] == 0) {
				caselle[riga + 1][colonna]
						= caselle[riga][colonna];
				caselle[riga][colonna] = 0;
			}
		}
	}

	private void spostaSopra(int riga, int colonna) {
		if (caselle[riga][colonna] != 0 && riga != 0) {
			spostaSopra(riga - 1, colonna);
			if (caselle[riga - 1][colonna] == 0) {
				caselle[riga - 1][colonna]
						= caselle[riga][colonna];
				caselle[riga][colonna] = 0;
			}
		}
	}

	private void spostaDestra(int riga, int colonna) {
		if (caselle[riga][colonna] != 0 && colonna != 3) {
			spostaDestra(riga, colonna + 1);
			if (caselle[riga][colonna + 1] == 0) {
				caselle[riga][colonna + 1]
						= caselle[riga][colonna];
				caselle[riga][colonna] = 0;
			}
		}
	}

	private void spostaSinistra(int riga, int colonna) {
		if (caselle[riga][colonna] != 0 && colonna != 0) {
			spostaSinistra(riga, colonna - 1);
			if (caselle[riga][colonna - 1] == 0) {
				caselle[riga][colonna - 1]
						= caselle[riga][colonna];
				caselle[riga][colonna] = 0;
			}
		}
	}





}

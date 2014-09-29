package it.univr.gioco15;

import java.util.Arrays;
import java.util.Random;

public class Gioco15 {
	private int[][] tabella = new int[4][4];

	public Gioco15() {
		inizializzaAMenoUno();
		inizializzaACaso();
	}

	private void inizializzaAMenoUno() {
		for (int[] riga: tabella)
			Arrays.fill(riga, -1);
	}

	private void inizializzaACaso() {
		Random random = new Random();

		for (int[] riga: tabella)
			for (int j = 0; j < 4; j++) {
				int r;

				do {
					r = random.nextInt(16);
				}
				while (contieneGia(r));

				riga[j] = r;
			}
	}

	private boolean contieneGia(int r) {
		for (int[] riga: tabella)
			for (int elemento: riga)
				if (elemento == r)
					return true;

		return false;
	}

	public String toString() {
		String ris = "";

		for (int[] riga: tabella) {
			for (int elemento: riga)
				if (elemento == 0)
					ris += "   ";
				else
					ris += String.format(" %2d", elemento);

			ris += '\n';
		}

		return ris;
	}

	public void sposta(int x, int y) {
		x--;
		y--;

		provaASinistra(x, y);
		provaADestra(x, y);
		provaInAlto(x, y);
		provaInBasso(x, y);
	}

	private void provaInBasso(int x, int y) {
		if (x >= 0 && x < 4 && y >= 0 && y < 3) {
			provaInBasso(x, y + 1);
			if (tabella[y + 1][x] == 0) {
				tabella[y + 1][x] = tabella[y][x];
				tabella[y][x] = 0;
			}
		}
	}

	private void provaInAlto(int x, int y) {
		if (x >= 0 && x < 4 && y > 0 && y < 4) {
			provaInAlto(x, y - 1);
			if (tabella[y - 1][x] == 0) {
				tabella[y - 1][x] = tabella[y][x];
				tabella[y][x] = 0;
			}
		}
	}

	private void provaASinistra(int x, int y) {
		if (x > 0 && x < 4 && y >= 0 && y < 4) {
			provaASinistra(x - 1, y);
			if (tabella[y][x - 1] == 0) {
				tabella[y][x - 1] = tabella[y][x];
				tabella[y][x] = 0;
			}
		}
	}

	private void provaADestra(int x, int y) {
		if (x >= 0 && x < 3 && y >= 0 && y < 4) {
			provaADestra(x + 1, y);
			if (tabella[y][x + 1] == 0) {
				tabella[y][x + 1] = tabella[y][x];
				tabella[y][x] = 0;
			}
		}
	}
}

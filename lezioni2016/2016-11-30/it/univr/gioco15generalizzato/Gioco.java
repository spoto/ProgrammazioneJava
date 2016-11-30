package it.univr.gioco15generalizzato;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Gioco {
	private final Tessera[][] tessere;

	public Gioco(FattoriaDiTessere fattoria, int width, int height) {
		tessere = new Tessera[height][width];
	
		Random random = new Random();
		int rigaVuota = random.nextInt(height);
		int colonnaVuota = random.nextInt(width);
		
		Tessera[] generate = new Tessera[height * width];
		int lenGenerate = 0;

		for (int riga = 0; riga < height; riga++)
			for (int colonna = 0; colonna < width; colonna++)
				if (riga != rigaVuota || colonna != colonnaVuota) {
					Tessera nuova;

					do {
						nuova = fattoria.mkRandom();
					}
					while (contenutaIn(nuova, generate));
					
					tessere[riga][colonna] = nuova;
					generate[lenGenerate++] = nuova;
				}
	}

	private boolean contenutaIn(Tessera nuova, Tessera[] generate) {
		for (Tessera tessera: generate)
			if (nuova.equals(tessera))
				return true;

		return false;
	}

	public String toString() {
		String risultato = "";
		for (int riga = 0; riga < tessere.length; riga++) {
			for (int colonna = 0; colonna < tessere[riga].length; colonna++)
				if (tessere[riga][colonna] == null)
					risultato += "   \t";
				else
					risultato += tessere[riga][colonna].toString() + "\t";

			risultato += '\n';
		}
		
		return risultato;
	}

	public boolean risolto() {
		Tessera previous = null;
		for (int riga = 0; riga < tessere.length; riga++) {
			for (int colonna = 0; colonna < tessere[riga].length; colonna++) {
				if (tessere[riga][colonna] == null)
					return riga == tessere.length - 1 && colonna == tessere[riga].length - 1;

				if (previous != null && previous.compareTo(tessere[riga][colonna]) > 0)
					return false;

				previous = tessere[riga][colonna];
			}
		}

		return false;
	}
}

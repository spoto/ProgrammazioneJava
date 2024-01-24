package it.univr.quindici;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// un gioco con tessere che contengono valori di tipo T
public class Gioco<T extends Comparable<T>> {
	private final int width, height;
	
	// le tessere del gioco: questa lista le contiene per righe
	// (la prima riga seguita dalla seconda riga seguita dall terza riga ecc.);
	// questa lista contiene null nel punto vuoto del gioco
	private final List<Tessera<T>> tessere = new ArrayList<>();

	public Gioco(FattoriaDiTessere<T> fattoria, int width, int height) {
		this.width = width;
		this.height = height;
		
		// costruiamo la lista "tessere": dovra' contenere
		// tessere casuali tutte diverse fra di loro
		// e un elemento casuale a null: in totale la lista "tessere"
		// dovra' avere quindi width * height elementi di cui uno solo a null

		// usando un insieme, evitiamo le ripetizioni
		Set<Tessera<T>> insieme = new HashSet<>();
		while (insieme.size() < width * height - 1) {
			Tessera<T> tessera = fattoria.get();
			if (insieme.add(tessera))
				// se e' stato aggiunto all'insieme, vuol dire che
				// non e' ripetuto e lo aggiungiamo anche alla lista
				this.tessere.add(tessera);
		}

		// posizioniamo un elemento a null in una posizione casuale:
		// gli elementi successivi verranno spostati di una posizione
		// in avanti nella lista
		Random random = new Random();
		int xVuota = random.nextInt(width);
		int yVuota = random.nextInt(height);
		this.tessere.add(xVuota + yVuota * width, null);
	}

	public String toString() {
		String result = "";

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				if (tessere.get(x + y * width) != null)
					result += String.format("%5s ", tessere.get(x + y * width).toString());
				else
					result += "      ";

			result += "\n";
		}

		return result;
	}

	// determina se il gioco e' risolto:
	// 1) la posizione vuota deve essere in basso a destra, e
	// 2) le tessere devono essere in ordine crescente (per riga e colonna)
	public boolean risolto() {
		// corretto poiche' il costruttore ci garantisce che tutte le tessere sono distinte
		// e che c'e' un solo elemento a null
		for (int pos = 0; pos < width * height - 2; pos++)
			if (tessere.get(pos) == null || tessere.get(pos + 1) == null || tessere.get(pos).compareTo(tessere.get(pos + 1)) > 0)
				return false;

		return true;
	}
}

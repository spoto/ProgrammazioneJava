package it.univr.dadi;

import java.util.ArrayList;
import java.util.List;

/**
 * Una classe che rappresenta l'esecuzione di piu' lanci con dei dadi.
 * Permette di vedere i risultati ottenuti e la frequenza dei numeri ottenuti.
 */
public class Lanci {
	private final Dado[] dadi;
	private final List<Integer> lanci = new ArrayList<>();

	/**
	 * Costruisce un'esecuzione di quanti lanci con i dadi indicati.
	 * Questo costruttore eseguire i lanci richiesti con i dadi forniti
	 * e si salvera' le informazioni necessarie a implementare i metodi
	 * della classe.
	 * 
	 * @param quanti il numero di lanci da eseguire
	 * @param dadi i dadi da lanciare. Per ogni lancio, il risultato e'
	 *             la somma dei risultati di ciascun dado
	 * @throws IllegalArgumentException se quanti non e' positivo oppure
	 *         se non vengono forniti dadi da lanciare
	 */
	public Lanci(int quanti, Dado... dadi) {
		if (quanti <= 0)
			throw new IllegalArgumentException("Bisogna fare almeno un lancio");

		if (dadi.length <= 0)
			throw new IllegalArgumentException("Bisogna fornire almeno un dado");

		this.dadi = dadi;

		for (int i = 1; i <= quanti; i++) {
			int somma = 0;
			for (Dado dado: dadi)
				somma += dado.lancio();

			lanci.add(somma);
		}
	}

	/**
	 * Restituisce la sequenza dei risultati ottenuti dal costruttore lanciando i dadi.
	 * Sara' una stringa fatta da una sequenza, fra parentesi quadre, di numeri separati da virgola.
	 */
	@Override
	public final String toString() {
		return lanci.toString();
	}

	/**
	 * Restituisce una rappresentazione a istogramma delle frequenze dei
	 * numeri ottenuti dal costruttore lanciando i dadi. Per ogni numero
	 * ottenuto, questi istogramma rappresentano quante volte quel numero e' stato
	 * ottenuto. Gli istogrammi sono fatti da una sequenza di asterischi lunga
	 * in modo proporzionale alla frequenza, seguita dalla frequenza tra parentesi
	 * tonde. Si vedano gli esempi nel testo del compito.
	 */
	public final String frequenze() {
		int min = dadi.length;
		int max = 0;
		for (Dado dado: dadi)
			max += dado.facce;

		int[] frequenze = new int[max + 1];
		for (int lancio: lanci)
			frequenze[lancio]++;

		String istogramma = "";
		for (int i = min; i <= max; i++) {
			double frequenza = frequenze[i] * 100.0 / lanci.size();
			istogramma += String.format("%3d: %s (%.1f%%)\n", i, barra(i, frequenza), frequenza);
		}

		return istogramma;
	}

	protected String barra(int i, double frequenza) {
		String barra = "";
		for (int j = 1; j <= frequenza; j++)
			barra += "*";

		return barra;
	}
}

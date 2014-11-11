import java.util.Arrays;


public class Insieme {

	private int[] elementi;

	/**
	 * Costruisce un insieme inizialmente vuoto
	 */
	public Insieme() {
		elementi = new int[0];
	}

	/**
	 * Costruisce un insieme inizializzato con gli elementi indicati
	 * @param elementi
	 */
	public Insieme(int... elementi) {
		this();
		
		add(elementi);
	}

	/**
	 * Aggiunge un elemento all'insieme
	 * @param elemento
	 */
	public void add(int elemento) {
		if (!contiene(elemento)) {
			// crea un nuovo array lungo elementi.length + 1
			int[] nuovo = new int[elementi.length + 1];
			
			// copiaci dentro il vecchio array elementi
			for (int pos = 0; pos < elementi.length; pos++)
				nuovo[pos] = elementi[pos];

			// scrivici in fondo elemento
			nuovo[elementi.length] = elemento;

			// sostituisci elementi col nuovo array più lungo
			elementi = nuovo;
		}
	}

	public void add(int... elementi) {
		for (int elemento: elementi)
			add(elemento);
	}

	private boolean contiene(int elemento) {
		for (int i: elementi)
			if (i == elemento)
				return true;

		return false;
	}

	/**
	 * Restituisce una descrizione stringa dell'insieme
	 */
	public String toString() {
		return Arrays.toString(elementi);
	}

	/**
	 * Restituisce il numero di elementi dell'insieme
	 * @return
	 */
	public int taglia() {
		return elementi.length;
	}
}

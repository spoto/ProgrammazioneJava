package it.univr.letters;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Una sequenza di caratteri "minuscola", cioe' fatta da
 * lettere minuscole dell'alfabeto inglese.
 * Sono ammesse lettere ripetute.
 */
public class LowerCase implements Letters {
	protected final static Random random = new Random();
	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO

	/**
	 * Crea una sequenza minuscola casuale.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */
	public LowerCase(int length) {
		// COMPLETARE
	}

	/**
	 * Crea una sequenza minuscola fatta dai caratteri di s, identici,
	 * nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non sono una sequenza minuscola
	 */
	public LowerCase(String s) {
		// COMPLETARE
	}

	@Override
	public final int length() {
		return 0; // MODIFICARE E COMPLETARE
	}

	@Override
	public final String toString() {
		return ""; // MODIFICARE E COMPLETARE
	}

	@Override
	public final void forEach(Consumer<Character> what) {
		// COMPLETARE
	}
}
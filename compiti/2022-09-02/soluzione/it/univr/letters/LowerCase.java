package it.univr.letters;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Una sequenza di caratteri "minuscola", cioe' fatta da
 * lettere minuscole dell'alfabeto inglese.
 * Sono ammesse lettere ripetute.
 */
public class LowerCase implements Letters {
	private final String s;
	protected final static Random random = new Random();

	/**
	 * Crea una sequenza minuscola casuale.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */
	public LowerCase(int length) {
		if (length < 0)
			throw new IllegalArgumentException("length non deve essere negativo");

		String s = "";
		for (int pos = 0; pos < length; pos++)
			s += (char) ('a' + random.nextInt('z' - 'a'));

		this.s = s;
	}

	/**
	 * Crea una sequenza minuscola fatta dai caratteri di s, identici,
	 * nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non sono una sequenza minuscola
	 */
	public LowerCase(String s) {
		for (int pos = 0; pos < s.length(); pos++) {
			char c = s.charAt(pos);
			if (c < 'a' || c > 'z')
				throw new IllegalArgumentException("Il carattere " + c + " non e' elfabetico minuscolo");
		}

		this.s = s;
	}

	@Override
	public final int length() {
		return s.length();
	}

	@Override
	public final String toString() {
		return s;
	}

	@Override
	public final void forEach(Consumer<Character> what) {
		for (int pos = 0; pos < s.length(); pos++)
			what.accept(s.charAt(pos));
	}
}
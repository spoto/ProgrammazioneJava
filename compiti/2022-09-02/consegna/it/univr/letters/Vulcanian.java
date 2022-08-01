package it.univr.letters;

/**
 * Una sequenza vulcaniana di lettere, cioe'
 * un caso particolare di sequenza LowerCase che e' fatta da due parti:
 * la prima parte contiene vocali in ordine alfabetico;
 * la seconda parte contiene consonanti in ordine alfabetico.
 */
public class Vulcanian extends LowerCase {

	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO

	/**
	 * Crea una sequenza vulcaniana di length lettere.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */	
	public Vulcanian(int length) {
		super(randomVulcanian(length));
	}

	/**
	 * Genera una stringa vulcaniana casuale lunga length.
	 */
	private static String randomVulcanian(int length) {
		return ""; // MODIFICARE E COMPLETARE
	}

	/**
	 * Crea una sequenza vulcaniana fatta dai caratteri di s,
	 * identici, nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non formano
	 *                                  una sequenza vulcaniana
	 */
	public Vulcanian(String s) {
		super(""); // MODIFICARE E COMPLETARE
	}
}
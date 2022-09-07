package it.univr.letters;

/**
 * Una sequenza vulcaniana di lettere, cioe'
 * un caso particolare di sequenza LowerCase che e' fatta da due parti:
 * la prima parte contiene vocali in ordine alfabetico;
 * la seconda parte contiene consonanti in ordine alfabetico.
 */
public class Vulcanian extends LowerCase {

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
		if (length < 0)
			throw new IllegalArgumentException("lunghezza negativa");

		// ci sono molti modi per farlo; qui per esempio prima si genera
		// un array casuale di lettere alfabetiche minuscole
		char[] arr = new char[length];
		for (int pos = 0; pos < length; pos++)
			arr[pos] = (char) ('a' + random.nextInt('z' - 'a'));

		// poi si ordina l'array in modo da mettere prima le vocali,
		// in ordine alfabetico, e poi le consonanti, in ordine alfabetico
		sortIntoVulcanian(arr, length);

		// alla fine si trasforma l'array in stringa
		return new String(arr);
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
		super(s);

		int length = s.length();
		for (int pos = 0; pos < length - 1; pos++)
			if (!sorted(s.charAt(pos), s.charAt(pos + 1)))
				throw new IllegalArgumentException("s non e' una stringa vulcaniana");
	}

	// determina se c e' una vocale minuscola
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	// determina se c1 viene prima di c2 nell'ordinamento vulcaniano:
	// si assume che entrambi i caratteri siano alfabetici minuscoli
	private static boolean sorted(char c1, char c2) {
		boolean c1IsVowel = isVowel(c1);
		boolean c2IsVowel = isVowel(c2);

		if (c1IsVowel && !c2IsVowel)
			return true;
		else if (!c1IsVowel && c2IsVowel)
			return false;
		else
			return c1 <= c2;
	}

	// fa una passata sull'array indicato scambiando
	// due caratteri consecutivi se non rispettano l'ordinamento vulcaniano
	private static boolean swap(char array[], int length) {
		boolean ho_fatto_scambio = false;
		for (int pos = 0; pos < length - 1; pos++)
			if (!sorted(array[pos], array[pos + 1])) {
				// scambia(array[pos] con array[pos + 1])
				char temp = array[pos];
				array[pos] = array[pos + 1];
				array[pos + 1] = temp;
				ho_fatto_scambio = true;
			}

		return ho_fatto_scambio;      
	}

	// riceve un array minuscolo arr e ne sposta i caratteri in modo che
	// arr diventi vulcaniano (prima le vocali, in ordine alfabetico,
	// poi le consonanti, in ordine alfabetico)
	private static void sortIntoVulcanian(char arr[], int length) {
		while (swap(arr, length));  
	}
}

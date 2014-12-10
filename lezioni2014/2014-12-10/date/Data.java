package date;
/**
 * Una data descrive un giorno all'interno del calendario.
 * Una data potrebbe essere usata per questi scopi:
 * 
 * <ul>
 * <li> rappresentare la data di nascita di una persona
 * <li> indicare l'ultima modifica di un file
 * <li> specificare la data di creazione di un documento
 * </ul>
 * 
 * @author Fausto Spoto fausto.spoto@univr.it
 */
public class Data implements Comparable<Data> {

	/**
	 * Il numero del giorno della data, da 1 a 31
	 */
	private int giorno;

	/**
	 * Il mese della data, da 1 a 12
	 */
	public int mese;

	/**
	 * L'anno della data, dal 1900 in poi
	 */
	private int anno;

	/**
	 * Costruttore di copia. Crea un oggetto identico
	 * all'originale passato come parametro.
	 * 
	 * @param originale la data di cui si deve creare una copia identica
	 */
	public Data(Data originale) {
		this.giorno = originale.giorno;
		this.mese = originale.mese;
		this.anno = originale.anno;
	}

	/**
	 * Modifica la data in modo da farla diventare il giorno
	 * successivo a quello rappresentato.
	 */
	public void next() {
		giorno++;
		if (giorno > getGiorniDelMese()[mese - 1]) {
			giorno = 1;
			mese++;
			if (mese == 13) {
				mese = 1;
				anno++;
			}
		}
	}

	
	// non fa parte dello stato
	private static String[] meseInItaliano = {
		"gennaio", "febbraio", "marzo", "aprile",
		"maggio", "giugno", "luglio", "agosto",
		"settembre", "ottobre", "novembre", "dicembre"
	};

	public Data(int a, int m, int g) throws DataIllegaleException {
		anno = a;
		mese = m;
		giorno = g;

		controllaData();
	}

	public Data(int m, int g) throws DataIllegaleException {
		this(2008, m, g);
	}

	public Data(int g) throws DataIllegaleException {
		this(1, g);
	}

	public Data() throws DataIllegaleException {
		this(1973, 1, 13);
	}

	private void controllaData() throws DataIllegaleException {
		int[] giorniDelMese = getGiorniDelMese();

		if (anno < 1900 || mese < 1 || mese > 12
				|| giorno < 1 || giorno > giorniDelMese[mese - 1]) {
			// blocca il programma con un'eccezione di tipo
			// java.lang.IllegalArgumentException
			throw new DataIllegaleException();
		}
	}

	private boolean bisestile(int anno) {
		return anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0);
	}

	public String toString() {
		return giorno + " " + meseInItaliano[mese - 1] + " " + anno;
	}

	private int[] getGiorniDelMese() {
		int[] giorniDelMese = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (bisestile(anno))
			giorniDelMese[1] = 29;

		return giorniDelMese;
	}

	/**
	 * Determina se questa data precede nel tempo un'altra data.
	 * 
	 * @param altra l'altra data con cui fare il confronto temporale
	 * @return true se e solo se questa data viene nel tempo
	 *         strettamente prima dell'altra
	 */
	public boolean precede(Data altra) {
		return this.giorniPassatiDallInizio() <
				altra.giorniPassatiDallInizio();
	}

	public int compareTo(Data altro) {
		if (this.giorniPassatiDallInizio() <
				altro.giorniPassatiDallInizio())
			return -1;
		else if (this.giorniPassatiDallInizio() >
				altro.giorniPassatiDallInizio())
			return 1;
		else
			return 0;
	}

	public int giorniPassatiDallInizioDellAnno() {
		int risultato = giorno;
		// aggiungiamo i giorni dei mesi precedenti
		int[] giorniDelMese = getGiorniDelMese();

		for (int pos = 0; pos < mese - 1; pos++)
			risultato += giorniDelMese[pos];

		return risultato;
	}

	public int giorniPassatiDallInizio() {
		int risultato = giorniPassatiDallInizioDellAnno();
		for (int pos = 1900; pos < anno - 1; pos++)
			risultato += bisestile(pos) ? 366 : 365;

		return risultato;
	}
}
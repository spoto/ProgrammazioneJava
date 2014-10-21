
public class Data {

	// stato dell'oggetto Data
	private int giorno;
	private int mese; // da 1 a 12
	private int anno; // dal 1900 in poi

	// non fa parte dello stato
	private static String[] meseInItaliano = {
		"gennaio", "febbraio", "marzo", "aprile",
		"maggio", "giugno", "luglio", "agosto",
		"settembre", "ottobre", "novembre", "dicembre"
	};

	public Data(int a, int m, int g) {
		anno = a;
		mese = m;
		giorno = g;

		controllaData();
	}

	public Data(int m, int g) {
		this(2008, m, g);
	}

	public Data(int g) {
		this(1, g);
	}

	public Data() {
		this(1973, 1, 13);
	}

	private void controllaData() {
		int[] giorniDelMese = getGiorniDelMese();

		if (anno < 1900 || mese < 1 || mese > 12
				|| giorno < 1 || giorno > giorniDelMese[mese - 1])
			System.out.println("data illegale");
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

	public boolean precede(Data altra) {
		return this.giorniPassatiDallInizio() <
				altra.giorniPassatiDallInizio();
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

public class Data {

	private int giorno;
	private int mese;
	private int anno;
			
	private static String[] nomiMesi = {
		"gennaio", "febbraio", "marzo",
		"aprile", "maggio", "giugno",
		"luglio", "agosto", "settembre",
		"ottobre", "novembre", "dicembre"
	};

	private static int[] numeroGiorni = {
		31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};

	public Data(int g, int m, int a) throws DataIllegaleException {
		this.giorno = g;
		this.mese = m;
		this.anno = a;

		controllaData();
	}

	public Data(int g, int m) throws DataIllegaleException {
		// vai al costruttore Data(int g, int m, int a)
		// usando a = 2008
		this(g, m, 2008);
	}

	public Data(int g) throws DataIllegaleException {
		this(g, 1, 2008);
	}

	public Data() {
		this.giorno = 13;
		this.mese = 1;
		this.anno = 1973;
	}

	private void controllaData() throws DataIllegaleException {
		if (!dataValida())
			throw new DataIllegaleException();
	}

	private boolean dataValida() {
		if (bisestile(anno))
			numeroGiorni[1] = 29;
		else
			numeroGiorni[1] = 28;

		return !(anno < 1900 || mese < 1 || mese > 12 || giorno < 1
				|| giorno > numeroGiorni[mese - 1]);
	}

	public String toString() {
		return giorno + " " + nomiMesi[mese - 1] + " " + anno;                        
	}

	public int giorniPassatiDallInizio() {
		int ris = giorniPassatiDallInizioDellAnno();

		for (int cursore = anno - 1; cursore >= 1900; cursore--)
			ris += bisestile(cursore) ? 366 : 365;

		return ris;
	}

	/**
	 * Determina se l'anno indicato è bisestile.
	 */

	private boolean bisestile(int a) {
		return (a % 4 == 0 && a % 100 != 0) || a % 400 == 0;
	}

	public int giorniPassatiDallInizioDellAnno() {
		if (bisestile(anno))
			numeroGiorni[1] = 29;
		else
			numeroGiorni[1] = 28;

		int ris = giorno;

		for (int cursore = mese - 1; cursore >= 1; cursore--)
			ris += numeroGiorni[cursore - 1];

		return ris;
	}
}
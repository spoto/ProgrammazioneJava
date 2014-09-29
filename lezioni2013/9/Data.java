
public class Data {
	private int giorno;
	private String mese;
	private int anno;

	public Data(int g, String m) {
		anno = 2013;
		giorno = g;
		mese = m;

		if (!isValid())
			System.out.println("Data inesistente");
	}

	public Data(int g, int m, int a) {
		String mesi[] = { "gennaio", "febbraio",
				"marzo", "aprile", "maggio",
				"giugno", "luglio", "agosto",
				"settembre", "ottobre", "novembre", "dicembre" };

		giorno = g;
		mese = mesi[m - 1];
		anno = a;

		if (!isValid())
			System.out.println("Data inesistente");
	}

	public Data(int g, String m, int a) {
		giorno = g;
		mese = m;
		anno = a;

		if (!isValid())
			System.out.println("Data inesistente");
	}

	private boolean isValid() {
		String mesi[] = { "gennaio", "febbraio",
				"marzo", "aprile", "maggio",
				"giugno", "luglio", "agosto",
				"settembre", "ottobre", "novembre", "dicembre" };

		int giorniPerMese[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int numMese;
		for (numMese = 1; numMese <= 12; numMese++)
			if (mese.equals(mesi[numMese - 1]))
				// trovato il mese, ragioniamo su giorno
				return giorno >= 1 && giorno <= giorniPerMese[numMese - 1];

		return false;
	}

	public boolean equals(Data altra) {
		return giorno == altra.giorno &&
			anno == altra.anno &&
			mese.equals(altra.mese);
	}

	public void setGiorno(int g) {
		int vecchioGiorno = giorno;
		giorno = g;

		if (!isValid()) {
			System.out.println("data risultante inesistente");
			giorno = vecchioGiorno;
		}
	}

	public void setMese(String m) {
		String vecchioMese = mese;
		mese = m;

		if (!isValid()) {
			System.out.println("data risultante in esistente");
			mese = vecchioMese;
		}
	}

	public void setAnno(int a) {
		anno = a;
	}

	public String getMese() {
		return mese;
	}

	public void stampa() {
		String temp = giorno + " " + mese;

		System.out.println
			(temp + " " + this.anno);
	}
}

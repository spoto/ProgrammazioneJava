
public class Data {

	private int giorno;
	private int mese; // da 1 a 12
	private int anno; // dal 1900 in poi
	
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
		this(2008, 1, g);
	}

	public Data() {
		this(1973, 1, 13);
	}

	private void controllaData() {
		int[] giorniDelMese = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (bisestile(anno))
			giorniDelMese[1] = 29;

		if (anno < 1900 || mese < 1 || mese > 12
				|| giorno < 1 || giorno > giorniDelMese[mese - 1])
			System.out.println("data illegale");
	}

	private boolean bisestile(int anno) {
		return anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0);
	}

	public String toString() {
		String[] meseInItaliano = {
				"gennaio", "febbraio", "marzo", "aprile",
				"maggio", "giugno", "luglio", "agosto",
				"settembre", "ottobre", "novembre", "dicembre"
		};

		return giorno + " " + meseInItaliano[mese - 1] + " " + anno;
	}
}

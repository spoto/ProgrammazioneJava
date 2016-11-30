package it.univr.gioco15generalizzato;

public class TesseraAlfabetica extends Tessera {
	private final String s;

	public TesseraAlfabetica(String s) {
		this.s = s;
	}

	public int compareTo(Tessera other) {
		if (other instanceof TesseraAlfabetica)
			return s.compareTo(((TesseraAlfabetica) other).s);
		else
			return -1;
	}

	public boolean equals(Object other) {
		return other instanceof TesseraAlfabetica
			&& s.equals(((TesseraAlfabetica) other).s);
	}

	public String toString() {
		return s;
	}

}

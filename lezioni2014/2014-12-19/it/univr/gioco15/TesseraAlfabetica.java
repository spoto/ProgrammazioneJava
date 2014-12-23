package it.univr.gioco15;

public final class TesseraAlfabetica extends Tessera {
	private final String s;
	TesseraAlfabetica(String s) { this.s = s; }

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraAlfabetica
			&& ((TesseraAlfabetica) other).s.equals(s);
	}

	public String toString() {
		return s;
	};

	@Override
	public int compareTo(Tessera o) {
		if (o instanceof TesseraAlfabetica)
			return s.compareTo(((TesseraAlfabetica)o).s);
		else
			throw new IllegalArgumentException();
	}
}
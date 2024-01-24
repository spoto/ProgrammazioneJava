package it.univr.quindici;

public final class TesseraAlfabetica extends Tessera {

	private final String s;

	TesseraAlfabetica(String s) {
		this.s = s;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraAlfabetica && ((TesseraAlfabetica) other).s.equals(s);
	}

	@Override
	public int hashCode() {
		return s.hashCode();
	}

	@Override
	public String toString() {
		return s;
	}

	@Override
	public int compareTo(Tessera o) {
		return s.compareTo(((TesseraAlfabetica) o).s);
	}
}
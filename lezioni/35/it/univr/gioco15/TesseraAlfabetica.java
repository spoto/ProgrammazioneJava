package it.univr.gioco15;

public class TesseraAlfabetica extends Tessera {

	private final String nome;

	public TesseraAlfabetica(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraAlfabetica &&
			((TesseraAlfabetica) other).nome.equals(nome);
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int compareTo(Tessera other) {
		if (other instanceof TesseraAlfabetica)
			return nome.compareTo(((TesseraAlfabetica) other).nome);
		else
			return this.getClass().getName().compareTo(other.getClass().getName());
	}
}

package it.univr.musica;

public class NotaIT extends Nota {
	public NotaIT(int semitono) {
		super(semitono);
	}

	@Override
	public Nota incrementa(int inc) {
		return new NotaIT((getSemitono() + inc) % 12);
	}

	@Override
	public String toString() {
		return nome[getSemitono()];
	}

	private final static String[] nome = {
		"do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si"
	};
}
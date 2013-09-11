package it.univr.musica;

public class NotaUK extends Nota {
	public NotaUK(int semitono) {
		super(semitono);
	}

	@Override
	public Nota incrementa(int inc) {
		return new NotaUK((getSemitono() + inc) % 12);
	}

	@Override
	public String toString() {
		return nome[getSemitono()];
	}

	private final static String[] nome = {
		"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
	};
}
package it.univr.musica;

public abstract class Nota {
	private final int semitono;

	protected Nota(int semitono) {
		if (semitono < 0 || semitono >= 12)
			throw new IllegalArgumentException("i semitoni vanno da 0 a 11");

		this.semitono = semitono;
	}

	@Override
	public abstract String toString();

	public abstract Nota incrementa(int inc);

	protected final int getSemitono() {
		return semitono;
	}
}
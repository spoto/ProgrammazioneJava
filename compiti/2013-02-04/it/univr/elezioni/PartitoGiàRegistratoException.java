package it.univr.elezioni;

public class PartitoGiàRegistratoException extends IllegalArgumentException {
	public PartitoGiàRegistratoException(Partito partito) {
		super(partito.getNome());
	}
}
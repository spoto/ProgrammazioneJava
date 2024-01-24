package it.univr.elezioni;

public class PartitoMaiRegistratoException extends IllegalArgumentException {
	public PartitoMaiRegistratoException(Partito partito) {
		super(partito.getNome());
	}
}
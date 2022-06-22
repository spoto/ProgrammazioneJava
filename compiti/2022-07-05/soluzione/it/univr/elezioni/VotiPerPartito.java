package it.univr.elezioni;

/**
 * Una coppia partito/voti ottenuti.
 */
public class VotiPerPartito {
	public final Partito partito;
	public final int voti;

	public VotiPerPartito(Partito partito, int voti) {
		this.partito = partito;
		this.voti = voti;
	}

	@Override
	public String toString() {
		return partito + ": " + voti;
	}
}
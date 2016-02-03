package it.univr.elezioni;

public class VotiPerPartito {
	private final Partito partito;
	private final int voti;

	public VotiPerPartito(Partito partito, int voti) {
		this.partito = partito;
		this.voti = voti;
	}

	@Override
	public String toString() {
		return partito + ": " + voti;
	}
}
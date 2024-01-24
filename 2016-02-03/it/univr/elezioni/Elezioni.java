package it.univr.elezioni;

import java.util.Iterator;

public class Elezioni implements Iterable<VotiPerPartito> {
	private int[] voti = new int[Partito.NUMERO_PARTITI];

	public void vota(Partito partito) {
		voti[partito.indice()]++;
	}

	@Override
	public String toString() {
		String result = "Risultati elezioni:\n\n";
		int numeroVotiEspressi = numeroVotiEspressi();

		int num = 1;
		for (Partito partito: Partito.elementi())
			result += String.format("%d %15s: %5d voti (%.2f%%)\n",
					num++,
					partito,
					votiPer(partito),
					100.0 * votiPer(partito) / numeroVotiEspressi);

		return result;
	}

	protected final int numeroVotiEspressi() {
		int sum = 0;
		for (Partito partito: Partito.elementi())
			sum += votiPer(partito);

		return sum;
	}

	protected final int votiPer(Partito partito) {
		return voti[partito.indice()];
	}

	@Override
	public final Iterator<VotiPerPartito> iterator() {
		return new ElezioniIterator();
	}

	private class ElezioniIterator implements Iterator<VotiPerPartito> {
		private int numeroPartito;

		@Override
		public boolean hasNext() {
			return numeroPartito < Partito.NUMERO_PARTITI;
		}

		@Override
		public VotiPerPartito next() {
			Partito prossimoPartito = Partito.elementi()[numeroPartito++];
			return new VotiPerPartito(prossimoPartito, votiPer(prossimoPartito));
		}
	}
}
package it.univr.elezioni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Un oggetto di questa classe permette di registrare voti per dei partiti.
 * Iterando su questo oggetto, si ottengono delle coppie partito/voti ottenuti,
 * messe in ordine crescente per partito.
 */
public class Elezioni implements Iterable<VotiPerPartito> {
	private final Map<Partito, Integer> voti = new HashMap<>();

	// registra un voto per il partito indicato
	public final void vota(Partito partito) {
		voti.put(partito, 1 + votiPer(partito));
	}

	/**
	 * Ritorna una stringa che descrive l'elezione, del tipo:

1        Bassotti:  4467 voti (28.11%)
2         Caotico:  4679 voti (29.45%)
3          Felice:  1591 voti (10.01%)
4        Floreale:  3950 voti (24.86%)
5      Pensionati:  1202 voti (7.56%)

	   I partiti sono riportati in ordine crescente, con a sinistra un indice
	   crescente del partito (da 1 in su). Dopo il nome del partito viene riportato
	   il numero dei voti ottenuti e la percentuale ottenuta fra tutti i voti espressi.
	 */
	@Override
	public String toString() {
		int numeroVotiEspressi = numeroVotiEspressi();
		int num = 1;
		String result = "";
		for (VotiPerPartito vpp: this)
			result += String.format("%d %15s: %5d voti (%.2f%%)\n",
					num++,
					vpp.partito,
					vpp.voti,
					100.0 * vpp.voti / numeroVotiEspressi);

		return result;
	}

	// restituisce il numero totale dei voti
	private int numeroVotiEspressi() {
		int sum = 0;
		for (int v: voti.values())
			sum += v;
		
		return sum;

		// oppure usando gli stream:
		//return voti.values().stream().mapToInt(Integer::intValue).sum();
	}

	private int votiPer(Partito partito) {
		return voti.getOrDefault(partito, 0);
	}

	@Override
	public final Iterator<VotiPerPartito> iterator() {
		return new Iterator<VotiPerPartito>() {
			private final Iterator<Partito> it = new TreeSet<>(voti.keySet()).iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public VotiPerPartito next() {
				Partito prossimoPartito = it.next();
				return new VotiPerPartito(prossimoPartito, votiPer(prossimoPartito));
			}
		};
	}
}
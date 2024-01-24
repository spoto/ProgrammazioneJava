package it.univr.esami;

import java.util.Comparator;

public class EsamePerEsito extends Esame {

	@Override
	protected Comparator<Verbalizzazione> getComparator() {
		return new Comparator<Verbalizzazione>() {

			@Override
			public int compare(Verbalizzazione v1, Verbalizzazione v2) {
				int diff = v1.getEsito().compareTo(v2.getEsito());
				if (diff != 0)
					return diff;
				else
					return v1.getStudente().matricola - v2.getStudente().matricola;
			}
		};
	}
}
package it.univr.esami;

import java.util.Comparator;

public class EsamePerMatricola extends Esame {

	@Override
	protected Comparator<Verbalizzazione> getComparator() {
		return new Comparator<Verbalizzazione>() {

			@Override
			public int compare(Verbalizzazione v1, Verbalizzazione v2) {
				return v1.getStudente().matricola - v2.getStudente().matricola;
			}
		};
	}
}
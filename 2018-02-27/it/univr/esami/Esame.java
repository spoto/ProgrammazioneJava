package it.univr.esami;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Esame implements Iterable<Esame.Verbalizzazione> {
	private final Set<Studente> iscritti = new HashSet<>();
	private final SortedSet<Verbalizzazione> verbalizzazioni = new TreeSet<>(getComparator());
	
	public void iscrivi(Studente... studenti) {
		for (Studente studente: studenti)
			this.iscritti.add(studente);
	}

	public void verbalizza(Studente studente, Esito esito) throws VerbalizzazioneGiàEffettuataException, StudenteNonIscrittoException {
		if (!iscritti.contains(studente))
			throw new StudenteNonIscrittoException(studente);

		for (Verbalizzazione other: verbalizzazioni)
			if (other.studente.equals(studente))
				throw new VerbalizzazioneGiàEffettuataException(studente);

		this.verbalizzazioni.add(new Verbalizzazione(studente, esito));
	}

	public final String toString() {
		String result = "";
		for (Verbalizzazione verbalizzazione: this)
			result += verbalizzazione + "\n";

		return result;
	}

	protected abstract Comparator<Verbalizzazione> getComparator();

	@Override
	public final Iterator<Verbalizzazione> iterator() {
		return verbalizzazioni.iterator();
	}

	public final static class Verbalizzazione {
		private final Studente studente;
		private final Esito esito;
		
		private Verbalizzazione(Studente studente, Esito esito) {
			this.studente = studente;
			this.esito = esito;
		}

		public Studente getStudente() {
			return studente;
		}

		public Esito getEsito() {
			return esito;
		}

		@Override
		public boolean equals(Object other) {
			return other instanceof Verbalizzazione
					&& ((Verbalizzazione) other).esito == esito
					&& ((Verbalizzazione) other).studente.equals(studente);
		}

		@Override
		public int hashCode() {
			return studente.hashCode() ^ esito.hashCode();
		}

		@Override
		public String toString() {
			return String.format("%6d %20s %20s: %s", studente.matricola, studente.cognome, studente.nome, esito); 
		}
	}
}
package it.univr.elezioni;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Elezione {

	/**
	 * Le coalizioni registrate per questa elezione. Se un partito si presenta da solo,
	 * starà in una coalizione in cui è presente solo esso stesso
	 */

	private final Set<Coalizione> coalizioni = new HashSet<Coalizione>();

	/**
	 * Una mappa che associa a ciascun partito i voti che ha preso
	 */

	private final Map<Partito, Integer> votiPerPartito = new HashMap<Partito, Integer>();

	/**
	 * Registra il partito indicato come un partecipante all'elezione, dentro una
	 * coalizione di cui fa parte solo esso stesso. Se il partito è già registrato,
	 * genera una PartitoGiàRegistratoException.
	 */

	public void registra(Partito partito) {
		if (votiPerPartito.containsKey(partito))
			throw new PartitoGiàRegistratoException(partito);

		votiPerPartito.put(partito, 0);

		// all'inizio, un partito fa parte di una coalizione di cui è l'unico rappresentante
		// e che ha lo stesso nome del partito
		coalizioni.add(new Coalizione(partito.getNome(), partito));
	}

	/**
	 * Registra la coalizione indicata come partecipante all'elezione. Se esiste già una
	 * coalizione uguale, deve generare una eccezione di classe CoalizioneGiàPresenteException.
	 * Altrimenti i partiti della coalizione vengono eliminati da tutte le altre coalizioni,
	 * se ne facevano parte. Tali coalizione, se in tal modo diventassero vuote, devono venire
	 * de-registrate (eliminate) dall'elezione.
	 * Tutti i partiti della coalizione indicata sono automaticamente registrati all'elezione
	 */

	public void registra(Coalizione coalizione) {
		if (coalizioni.contains(coalizione))
			throw new CoalizioneGiàPresenteException(coalizione);

		Set<Colazione> clone = new HashSet<Coalizione>(coalizioni);
		// rimuoviamo i partiti di questa coalizione dalle altre coalizione
		for (Coalizione altraCoalizione: clone)
			for (Partito partito: coalizione)
				if (altraCoalizione.rimuovi(partito))
					// se un'altra coalizione è diventata vuota, la rimuoviamo
					coalizioni.remove(altraCoalizione);

		coalizioni.add(coalizione);

		for (Partito partito: coalizione)
			if (!votiPerPartito.containsKey(partito))
				votiPerPartito.put(partito, 0);
	}

	/**
	 * Registra un nuovo voto per il partito indicato (e quindi anche per la coalizione di cui esso fa parte).
	 * Se il partito non è registrato all'elezione, genera una PartitoMaiRegistratoException.
	 */

	public void registraVotoPer(Partito partito) {
		if (!votiPerPartito.containsKey(partito))
			throw new PartitoMaiRegistratoException(partito);

		votiPerPartito.put(partito, votiPerPartito.get(partito) + 1);
	}

	@Override
	public String toString() {
		String risultato = "";

		int votiTotali = sommaDiTuttiIVoti();

		for (Coalizione coalizione: coalizioni)
			risultato += toString(coalizione, votiTotali) + "\n";

		return risultato;
	}

	private String toString(Coalizione coalizione, int votiTotali) {
		String risultato = "Coalizione \"" + coalizione.getNome() + "\":\n";
		int votiAllaCoalizione = 0;

		for (Partito partito: coalizione) {
			int votiOttenuti = votiPerPartito.get(partito);
			votiAllaCoalizione += votiOttenuti;
			risultato += "  " + partito.getNome() + ": voti " + votiOttenuti + " (" + percentuale(votiOttenuti, votiTotali) + ")\n";
		}

		risultato += "Totale voti alla coalizione: " + votiAllaCoalizione + " (" + percentuale(votiAllaCoalizione, votiTotali) + ")\n";

		return risultato;
	}

	private static String percentuale(int votiOttenuti, int votiTotali) {
		return String.valueOf((int) (votiOttenuti * 10000.0 / votiTotali) / 100.0) + "%";
	}

	private int sommaDiTuttiIVoti() {
		int somma = 0;

		for (Partito partito: votiPerPartito.keySet())
		    somma += votiPerPartito.get(partito);
		
		return somma;
	}
}

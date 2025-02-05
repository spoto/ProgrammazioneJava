package it.univr.time;

import java.util.Iterator;

// un intervallo di tempo, da un istante iniziale
// in avanti, per un certo numero di secondi
public class Interval implements Iterable<Time> {
	// completare

	// crea un internal da start (incluso) a start + howManySeconds (escluso)
	// lancia IllegalArgumentException se howManySeconds è negativo
	public Interval(Time start, int howManySeconds) {
		// completate
	}

	// l'iteratore deve generare gli istanti
	// da start (incluso) a start + howManySeconds (escluso)
	@Override
	public Iterator<Time> iterator() {
		// completate
	}
}
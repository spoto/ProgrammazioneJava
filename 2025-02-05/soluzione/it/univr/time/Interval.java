package it.univr.time;

import java.util.Iterator;

// un intervallo di tempo, da un istante iniziale
// in avanti, per un certo numero di secondi
public class Interval implements Iterable<Time> {
	private final Time start;
	private final int howManySeconds;

	// crea un internal da start (incluso) a start + howManySeconds (escluso)
	// lancia IllegalArgumentException se howManySeconds è negativo
	public Interval(Time start, int howManySeconds) {
		if (howManySeconds < 0)
			throw new IllegalArgumentException();

		this.start = start;
		this.howManySeconds = howManySeconds;
	}

	// l'iteratore deve generare gli istanti
	// da start (incluso) a start + howManySeconds (escluso)
	@Override
	public Iterator<Time> iterator() {
		return new Iterator<Time>() {

			private int counter;
			private Time next = start;

			@Override
			public boolean hasNext() {
				return counter < howManySeconds;
			}

			@Override
			public Time next() {
				Time result = next;
				next = next.next();
				counter++;
				return result;
			}
		};
	}
}
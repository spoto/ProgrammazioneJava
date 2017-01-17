package com.hotmoka.examples.concurrency;
/**
 * A table, where philosophers sit, think and eat.
 * 
 * @author <A HREF="mailto:fausto.spoto@univr.it">Fausto Spoto</A>
 */

public class Philosophers {

	/**
	 * Builds a table where at least two philosophers are sitting and hold forks.
	 *
	 * @param names
	 * 			the names of the philosophers
	 * @throws IllegalArgumentException
	 * 			if fewer than two names are provided
	 */

	public Philosophers(String... names) {
		if (names.length < 2)
			throw new IllegalArgumentException("at least two philosophers must sit at a table");

		Fork[] forks = new Fork[names.length];
		for (int pos = 0; pos < forks.length; pos++)
			forks[pos] = new Fork();

		int pos = 0;
		for (String name: names)
			new Philosopher(name, forks[pos], forks[++pos % forks.length]).start();
	}

	/**
	 * Builds a test table with six philosophers.
	 *
	 * @param args
	 * 			unused
	 */

	public static void main(String[] args) {
		new Philosophers("Plato", "Socrates", "Aristoteles", "Parmenides", "Eraclitos", "Empedocles");
	}
}
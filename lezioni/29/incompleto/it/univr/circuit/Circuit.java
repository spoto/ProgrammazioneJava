package it.univr.circuit;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Circuit {

	private final static Random random = new Random();

	/**
	 * Crea un circuito a caso, di profondita' massima indicata.
	 *
	 * @param depth la profondita' massima, da 1 in su'
	 * @param variables i nomi delle variabili che possono essere usate dal circuito
	 * @return il circuito generato a caso
	 */

	public static Circuit mkRandom(int depth, Set<String> variables) {
		if (depth == 1)
			return chooseOneFrom(variables);
		else {
			switch (random.nextInt(4)) {
			case 0:
				return new And(mkRandom(depth - 1, variables), mkRandom(depth - 1, variables));
			case 1:
				return new Or(mkRandom(depth - 1, variables), mkRandom(depth - 1, variables));
			case 2:
				return new Not(mkRandom(depth - 1, variables));
			default:
				return chooseOneFrom(variables);
			}
		}
	}

	/**
	 * Sceglie e ritorna una variabile a caso fra quelle passate come argomento.
	 *
	 * @param variables l'insieme dei nomi delle variabili fra cui si può scegliere
	 * @return la variabile scelta
	 */

	private static Variable chooseOneFrom(Set<String> variables) {
		String[] variablesAsArray = variables.toArray(new String[variables.size()]);

		return new Variable(variablesAsArray[random.nextInt(variablesAsArray.length)]);
	}

	/**
	 * Determina se questo circuito è vero in un assegnamento.
	 *
	 * @param assignment l'assegnamento
	 * @return true se e solo se questo circuito è vero
	 *         in {@code assignment}
	 */

	public abstract boolean isTrueIn(Assignment assignment);

	/**
	 * Restituisce l'insieme dei nomi delle variabili che occorrono
	 * libere in questo circuito.
	 *
	 * @return l'insieme dei nomi
	 */

	public abstract Set<String> freeVariables();

	/**
	 * Restituisce true sse other è un circuito logicamente equivalente a
	 * questo circuito.
	 */

	@Override
	public final boolean equals(Object other) {
	    // da completare!
            return true;
	}

	/**
	 * Se due circuiti sono logicamente equivalenti, devono avere
	 * lo stesso codice hash.
	 */

	@Override
	public final int hashCode() {
	    return 0; // si può fare di meglio?
	}

	@Override
	public abstract String toString();
}
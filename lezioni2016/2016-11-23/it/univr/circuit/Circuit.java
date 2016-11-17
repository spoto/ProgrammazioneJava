package it.univr.circuit;

import java.util.Random;

public abstract class Circuit {

	private final static Random random = new Random();

	/**
	 * Crea un circuito a caso, di profondita' massima indicata.
	 *
	 * @param depth la profondita' massima, da 1 in su'
	 * @param variables i nomi delle variabili che possono essere usate dal circuito
	 * @return il circuito generato a caso
	 */

	public static Circuit mkRandom(int depth, String[] variables) {
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
	 * @param variables i nomi delle variabili fra cui si può scegliere
	 * @return la variabile scelta
	 */

	private static Variable chooseOneFrom(String[] variables) {
		return new Variable(variables[random.nextInt(variables.length)]);
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
	 * Restituisce le variabili che occorrono libere in questo circuito.
	 *
	 * @return le variabili
	 */

	public abstract Variable[] freeVariables();

	/**
	 * Restituisce true sse other è un circuito logicamente equivalente a
	 * questo circuito.
	 */

	@Override
	public final boolean equals(Object other) {
		if (other instanceof Circuit) {
			Circuit otherAsCircuit = (Circuit) other;

			Variable[] fv = new And(this, otherAsCircuit).freeVariables();

			return agreeOnAllPossibleAssignments(this, otherAsCircuit, fv, 0, new String[0]);
		}

		return false;
	}

	private boolean agreeOnAllPossibleAssignments(Circuit circuit1, Circuit circuit2, Variable[] vars, int pos, String[] choice) {
		if (pos == vars.length) {
			Assignment assignment = new Assignment(choice);
			return circuit1.isTrueIn(assignment) == circuit2.isTrueIn(assignment);
		}
		else {
			// devono coincidere sia se la variabile pos-esima è vera...
			return agreeOnAllPossibleAssignments(circuit1, circuit2, vars, pos + 1, expand(choice, vars[pos].getName()))
				// sia se è falsa...
				&& agreeOnAllPossibleAssignments(circuit1, circuit2, vars, pos + 1, choice);
		}
	}

	private String[] expand(String[] names, String name) {
		String[] res = new String[names.length + 1];
		System.arraycopy(names, 0, res, 0, names.length);
		res[names.length] = name;

		return res;
	}

	/**
	 * Se due circuiti sono logicamente equivalenti, devono avere
	 * lo stesso codice hash.
	 */

	@Override
	public final int hashCode() {
		//TODO
	    return 0; // sapete fare di meglio?
	}

	@Override
	public abstract String toString();
}
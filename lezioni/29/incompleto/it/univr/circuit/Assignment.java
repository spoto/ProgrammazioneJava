package it.univr.circuit;

import java.util.Set;
import java.util.HashSet;

/**
 * Un assegnamento specifica quali variabili sono considerate
 * vere e quali false.
 */

public class Assignment {

	/**
	 * L'insieme delle variabili considerate vere.
	 */

	private final Set<String> trueVariables = new HashSet<String>();

	/**
	 * Costruisce un assegnamento che assume vere esattamente
	 * le variabili indicate.
	 *
	 * @param trueVariables i nomi delle variabili da considerare vere
	 */

	public Assignment(Set<String> trueVariables) {
		for (String var: trueVariables)
			this.trueVariables.add(var);
	}

	/**
	 * Costruisce un assegnamento che assume vere esattamente
	 * le variabili indicate.
	 *
	 * @param trueVariables i nomi delle variabili da considerare vere
	 */

	public Assignment(String... trueVariables) {
		for (String var: trueVariables)
			this.trueVariables.add(var);
	}

	/**
	 * Determina se la variabile indicata è vera in questo assegnamento.
	 *
	 * @param var la variabile da controllare
	 * @return true se e solo se {@code var} è vera in
	 * 		   questo assegnamento
	 */

	public boolean valueOf(Variable var) {
		return trueVariables.contains(var.toString());
	}
}
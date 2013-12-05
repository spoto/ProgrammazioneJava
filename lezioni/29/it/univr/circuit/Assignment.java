package it.univr.circuit;

/**
 * Un assegnamento specifica quali variabili sono considerate
 * vere e quali false.
 */

public final class Assignment {

	/**
	 * Le variabili considerate vere.
	 */

	private final String[] trueVariables;

	/**
	 * Costruisce un assegnamento che assume vere esattamente
	 * le variabili indicate.
	 *
	 * @param trueVariables i nomi delle variabili da considerare vere
	 */

	public Assignment(String... trueVariables) {
		this.trueVariables = trueVariables;
	}

	/**
	 * Determina se la variabile indicata è vera in questo assegnamento.
	 *
	 * @param var la variabile da controllare
	 * @return true se e solo se {@code var} è vera in
	 * 		   questo assegnamento
	 */

	public boolean valueOf(Variable var) {
		for (String trueVariable: trueVariables)
			if (var.getName().equals(trueVariable))
				return true;

		return false;
	}
}
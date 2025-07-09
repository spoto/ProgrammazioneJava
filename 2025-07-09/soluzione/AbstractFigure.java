package it.univr.figures;

/**
 * Un'implementazione parziale di una figura. Implementa solo il toString(),
 * gli altri metodi dell'interfaccia saranno implementati dalle sottoclassi.
 */
public abstract class AbstractFigure implements Figure {

	@Override
	public final String toString() {
		int height = getHeight();
		String result = "";

		try {
			for (int row = 0; row < height; row++)
				result += getRow(row) + "\n";
		}
		catch (NoSuchRowException e) {
			// impossibile se il codice è corretto, perché stiamo accedendo dentro i limiti
			// delle righe valide della figura
		}

		return result;
	}
}
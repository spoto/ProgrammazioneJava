package it.univr.figures;

/**
 * Una figura che rappresenta un cerchio di raggio radius.
 */
public class Circle extends AbstractFigure {
	// AGGIUNGETE CAMPI SE SERVONO

	/**
	 * Costruisce la figura.
	 * 
	 * @param radius il raggio del cerchio
	 * @throws IllegalArgumentException se radius fosse <= 0
	 */
	public Circle(int radius) {
		// COMPLETATE
	}

	@Override
	public int getWidth() {
		// conoscendo il raggio, qual è la larghezza?

		// COMPLETATE
	}

	@Override
	public int getHeight() {
		// conoscendo il raggio, qual è l'altezza?

		// COMPLETATE
	}

	@Override
	public String getRow(int y) throws NoSuchRowException {
		// se y è fuori dal cerchio, lanciamo una NoSuchRowException
		// COMPLETATE

		String row = "";
		// il centro del cerchio si trova alle coordinate seguenti, dove 0.5 si
		// giustifica perché le coordinate iniziano da 0
		double xCenter = radius - 0.5;
		double yCenter = radius - 0.5;

		for (int x = 0; x < getWidth(); x++) {
			// calcoliamo sui double la distanza di (x, y) dal centro
			// del cerchio (xCenter, yCenter), approssimata per eccesso
			int distance = // COMPLETATE

			// se questa distanza è uguale al raggio, allora (x, y) è sulla circonferenza
			// e aggiungiamo un asterisco a row, altrimenti aggiungiamo uno spazio a row
			// COMPLETATE
		}

		return row;
	}
}

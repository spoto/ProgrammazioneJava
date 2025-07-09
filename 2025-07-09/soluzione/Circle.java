package it.univr.figures;

/**
 * Una figura che rappresenta un cerchio di raggio radius.
 */
public class Circle extends AbstractFigure {
	private final int radius;

	/**
	 * Costruisce la figura.
	 * 
	 * @param radius il raggio del cerchio
	 * @throws IllegalArgumentException se radius fosse <= 0
	 */
	public Circle(int radius) {
		if (radius < 1)
			throw new IllegalArgumentException("Un cerchio deve avere raggio >= 1");

		this.radius = radius;
	}

	@Override
	public int getWidth() {
		// conoscendo il raggio, qual è la larghezza?
		return 2 * radius;
	}

	@Override
	public int getHeight() {
		// conoscendo il raggio, qual è l'altezza?
		return 2 * radius;
	}

	@Override
	public String getRow(int y) throws NoSuchRowException {
		// se y è fuori dal cerchio, lanciamo un'eccezione
		if (y < 0 || y >= getHeight())
			throw new NoSuchRowException();

		String row = "";
		// il centro del cerchio si trova alle coordinate seguenti, dove 0.5 si
		// giustifica perché le coordinate iniziano da 0
		double xCenter = radius - 0.5;
		double yCenter = radius - 0.5;

		for (int x = 0; x < getWidth(); x++) {
			// calcoliamo sui double la distanza di (x, y) dal centro del cerchio, approssimata per eccesso
			int distance = (int) (1 + Math.sqrt((xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter - y)));
			// se questa distanza è uguale al raggio, allora siamo sulla circonferenza
			// e aggiungiamo un asterisco a row, altrimenti aggiungiamo uno spazio a row
			row += distance == radius ? "*" : " ";
		}

		return row;
	}
}

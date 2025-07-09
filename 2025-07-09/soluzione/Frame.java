package it.univr.figures;

/**
 * Una figura che rappresenta un'altra figura incorniciata
 * dentro una cornice di caratteri @.
 */
public class Frame extends AbstractFigure {
	private final Figure figure;

	/**
	 * Costruisce la figura, a partire dalla figura da incorniciare.
	 * 
	 * @param figure la figura da incorniciare
	 */
	public Frame(Figure figure) {
		this.figure = figure;
	}

	@Override
	public int getWidth() {
		// se conosciamo la larghezza di figure, qual è la larghezza di figure incornicata?
		return 2 + figure.getWidth();
	}

	@Override
	public int getHeight() {
		// se conosciamo l'altezza di figure, qual è l'altezza di figure incornicata?
		return 2 + figure.getHeight();
	}

	@Override
	public String getRow(int n) throws NoSuchRowException {
		// suggerimento: distinguiamo il caso della prima o ultima riga della figura con la cornice
		// dal caso delle altre righe della figura con la cornice
		if (n == 0 || n == getHeight() - 1)
			// la prima e l'ultima riga sono fatte da soli "@"
			return "@".repeat(getWidth());
		else
			// le altre righe sono fatte dalla riga corrispondente (cioè n - 1) di figure,
			// con "@" aggiunti prima e dopo
			return "@" + figure.getRow(n - 1) + "@";
	}
}
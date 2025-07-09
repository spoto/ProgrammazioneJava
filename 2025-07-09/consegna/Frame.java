package it.univr.figures;

/**
 * Una figura che rappresenta un'altra figura incorniciata
 * dentro una cornice di caratteri @.
 */
public class Frame extends AbstractFigure {
	// AGGIUNGETE CAMPI SE SERVONO

	/**
	 * Costruisce la figura, a partire dalla figura da incorniciare.
	 * 
	 * @param figure la figura da incorniciare
	 */
	public Frame(Figure figure) {
		// COMPLETATE
	}

	@Override
	public int getWidth() {
		// se conosciamo la larghezza di figure, qual è la larghezza di figure incornicata?

		// COMPLETATE
	}

	@Override
	public int getHeight() {
		// se conosciamo l'altezza di figure, qual è l'altezza di figure incornicata?

		// COMPLETATE
	}

	@Override
	public String getRow(int n) throws NoSuchRowException {
		// suggerimento: distinguiamo il caso della prima o ultima riga della figura con la cornice
		// dal caso delle altre righe della figura con la cornice

		// COMPLETATE
	}
}
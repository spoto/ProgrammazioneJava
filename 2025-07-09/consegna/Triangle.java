package it.univr.figures;

/**
 * Una figura che rappresenta un triangolo rettangolo, con l'angolo
 * retto posizionato in alto, di altezza height.
 */
public class Triangle extends AbstractFigure {
	// AGGIUNGETE CAMPI SE SERVONO

	/**
	 * Costruisce la figura.
	 * 
	 * @param height l'altezza del triangolo
	 * @throws IllegalArgumentException se height fosse <= 0
	 */
	public Triangle(int height) {
		// COMPLETATE
	}

	@Override
	public int getWidth() {
		// se l'altezza è height, quanto sarà la base del triangolo?
		// aiutatevi con il disegno nelle stampe di esempio del compito

		// COMPLETATE
	}

	@Override
	public int getHeight() {
		// COMPLETATE
	}

	@Override
	public String getRow(int n) throws NoSuchRowException {
		// suggerimento: distinguete i casi: prima riga, ultima riga, righe in mezzo, altre righe

		// COMPLETATE
	}
}
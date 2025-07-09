package it.univr.figures;

/**
 * Una figura che rappresenta un triangolo rettangolo, con l'angolo
 * retto posizionato in alto, di altezza height.
 */
public class Triangle extends AbstractFigure {
	private final int height;

	/**
	 * Costruisce la figura.
	 * 
	 * @param height l'altezza del triangolo
	 * @throws IllegalArgumentException se height fosse <= 0
	 */
	public Triangle(int height) {
		if (height < 1)
			throw new IllegalArgumentException("Un triangolo deve avere altezza >= 1");

		this.height = height;
	}

	@Override
	public int getWidth() {
		// se l'altezza è height, quanto sarà la base del triangolo?
		// aiutatevi con il disegno nelle stampe di esempio del compito
		return 2 * height - 1;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getRow(int n) throws NoSuchRowException {
		// suggerimento: distinguete i casi: prima riga, ultima riga, righe in mezzo, altre righe
		if (n == 0)
			// la prima riga è fatta da (height - n - 1) spazi, seguiti da un asterisco,
			// seguito da (height - n - 1) spazi
			return " ".repeat(height - n - 1) + "*" + " ".repeat(height - n - 1);
		else if (n < height - 1)
			// le righe in mezzo sono fatte da (height - n - 1) spazi,
			// seguiti da un asterisco, seguiti da 2 * n - 1 spazi,
			// seguiti da un asterisco, seguiti da (height - n - 1) spazi
			return " ".repeat(height - n - 1) + "*" + " ".repeat(2 * n - 1) + "*" + " ".repeat(height - n - 1);
		else if (n == height - 1)
			// l'ultima riga è fatta da soli asterischi
			return "*".repeat(getWidth());
		else
			throw new NoSuchRowException();
	}
}
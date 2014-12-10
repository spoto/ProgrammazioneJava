package date;

import java.util.Arrays;

public class OrdinatoreStudenti {
	public void ordina(Studente[] array) {
		while (swap(array));
	}

	/**
	 * @param array
	 * @return true se e solo se ha fatto
	 *         almeno uno scambio
	 */
	private boolean swap(Studente[] array) {
		boolean scambio = false;

		for (int pos = 0; pos < array.length - 1; pos++)
			if (array[pos + 1].haMatricolaMinore(array[pos])) {
				Studente temp = array[pos + 1];
				array[pos + 1] = array[pos];
				array[pos] = temp;
				scambio = true;
			}

		return scambio;
	}

	public static void main(String[] args) throws DataIllegaleException {
		Studente[] array = { new Studente("Giorgio", 151545),
				new Studente("Roberto", 345234),
				new Studente("Camillo", 98768),
				new Studente("Giulia", 231567) };

		new OrdinatoreStudenti().ordina(array);

		System.out.println(Arrays.toString(array));
	}
}


public class Ordina {

	public static void main(String[] args) {
		Data[] array = new Data[] {
			new Data(13, 1, 1980),
			new Data(8, 4, 1974),
			new Data(20, 8, 1990),
			new Data(8, 12, 1989),
			new Data(18, 8, 1990)
		};

		ordina(array);

		for (Data d: array)
			System.out.println(d);

		Persona[] persone = new Persona[] {
			new Persona("giorgio", new Data(13, 1, 1980)),
			new Persona("alberto", new Data(8, 4, 1974)),
			new Persona("alessandra", new Data(13, 1, 1980)),
			new Persona("roberto", new Data(8, 12, 1989)),
			new Persona("Samuele", new Data(18, 8, 1990))
		};

		ordina(persone);

		for (Persona p: persone)
			System.out.println(p);
	}

	public static void ordina(Ordinabile[] date) {
		while (swap(date));
	}

	private static boolean swap(Ordinabile[] date) {
		boolean almenoUnoScambio = false;

		for (int pos = 0; pos < date.length - 1; pos++)
			if (date[pos + 1].precede(date[pos])) {
				// invertiamole
				Ordinabile temp = date[pos];
				date[pos] = date[pos + 1];
				date[pos + 1] = temp;
				almenoUnoScambio = true;
			}

		return almenoUnoScambio;
	}
}

package it.univr.elezioni;

import java.util.Random;

public class Main {

	private final static Partito[] partiti =
		new Partito[] {
			new Partito("Partito dei belli"),
			new Partito("Partito dei brutti"),
			new Partito("Partito mai tornato"),
			new Partito("Partito dei fiori"),
			new Partito("Partito di tutti"),
			new Partito("Partito di titti"),
			new Partito("Partito dei nonni")
		};

	public static void main(String[] args) {
		Elezione e = creaElezione();
		generaVotiACaso(e);
		System.out.println(e);
	}

	private static Elezione creaElezione() {
		Elezione e = new Elezione();

		// il partiro dei belli fa inizialmente coalizione da solo
		e.registra(partiti[0]);

		e.registra(partiti[1]);
	
		e.registra(new Coalizione("Siamo i più forti", partiti[2], partiti[3]));

		// adesso inseriamo il partito dei belli dentro una coalizione a quattro
		e.registra(new Coalizione("Futuro radioso", partiti[0], partiti[4], partiti[5], partiti[6]));

		try {
			// questo genera un'eccezione perché il "Partito di titti" è già registrato
			// poiché la sua coalizione "Futuro radioso" è stata registrata
			e.registra(new Partito("Partito di titti"));
		}
		catch (PartitoGiàRegistratoException exc) {
			System.out.println(exc);
		}

		return e;
	}

	private static void generaVotiACaso(Elezione e) {
		Random random = new Random();
		for (int i = 0; i < 89; i++)
			e.registraVotoPer(partiti[Math.abs(random.nextInt()) % 7]);
	}
}

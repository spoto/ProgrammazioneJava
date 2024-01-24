package it.univr.elezioni;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// creo cinque partiti
		Partito[] partiti = new Partito[] {
			new Partito("Pensionati"),
			new Partito("Felice"),
			new Partito("Floreale"),
			new Partito("Caotico"),
			new Partito("Bassotti")
		};

		// elezioni inizialmente vuote
		Elezioni elezioni = new ElezioniVincitore();

		// aggiungo dei voti casuali per i partiti
		Random random = new Random();
		for (Partito partito: partiti) {
			int voti = random.nextInt(10000);
			for (int i = 0; i < voti; i++)
				elezioni.vota(partito);
		}

		// stampo le elezioni con indicazione di vincitore
		System.out.println(elezioni);
	}
}
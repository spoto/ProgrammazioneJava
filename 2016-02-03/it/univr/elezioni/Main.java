package it.univr.elezioni;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		Partito[] partiti = Partito.values();
		Elezioni elezioni = new ElezioniIstogramma();

		for (Partito partito: partiti) {
			int voti = random.nextInt(10000);
			for (int i = 0; i < voti; i++)
				elezioni.vota(partito);
		}

		System.out.println(elezioni);

		for (VotiPerPartito vpp: elezioni)
			System.out.println(vpp);
	}
}
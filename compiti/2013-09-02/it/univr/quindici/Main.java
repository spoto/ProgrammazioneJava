package it.univr.quindici;

public class Main {
	public static void main(String[] args) {
		Gioco gioco = new Gioco(new FattoriaDiTessereAlfabetiche(), 4, 4);
		System.out.println(gioco);

		FattoriaDiTessere f = new FattoriaDiTessereNumeriche(8);
		do {
			gioco = new Gioco(f, 3, 2);
			System.out.println(gioco);
		}
		while (!gioco.risolto());
	}
}

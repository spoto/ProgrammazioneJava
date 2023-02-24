package it.univr.quindici;

public class Main {
	public static void main(String[] args) {
		// gioco 4x4 con tessere alfabetiche di lunghezza da 1 a 5 inclusi
		System.out.println(new Gioco<>(new FattoriaDiTessereAlfabetiche(), 4, 4));

		FattoriaDiTessere<Integer> f = new FattoriaDiTessereNumeriche(8);
		Gioco<Integer> gioco;
		do {
			// gioco 3x2 con tessere numeriche da 1 a 8 inclusi
			gioco = new Gioco<>(f, 3, 2);
			System.out.println(gioco);
		}
		while (!gioco.risolto());
	}
}

package it.univr.musica;

public class Main {
	public static void main(String[] args) {
		Canzone boccaDiRosa = new CanzoneImpl("Bocca di Rosa", new NotaIT(11), new NotaIT(2), new NotaIT(3), new NotaIT(6));
		Canzone letItBe = new CanzoneImpl("Let it be", new NotaUK(3), new NotaUK(5), new NotaUK(0));

		System.out.println(boccaDiRosa);
		System.out.println(letItBe);
		System.out.println(new CanzoneRibasata(boccaDiRosa, 5));
		System.out.println(new CanzoneRibasata(letItBe, 23));
	}
}

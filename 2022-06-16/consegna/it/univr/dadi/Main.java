package it.univr.dadi;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lanciamo 20 volte due dadi a sei facce");
		Lanci l = new Lanci(20, new D6(), new D6());
		System.out.println("Lanci ottenuti: " + l);
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a sei facce e uno a dieci facce");
		l = new Lanci(10000, new D6(), new D10());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a otto facce");
		l = new Lanci(10000, new D8());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte tre dadi a sei facce");
		l = new Lanci(10000, new D6(), new D6(), new D6());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte tre dadi a sei facce, usando barre diverse");
		l = new LanciBarreDiverse(10000, new D6(), new D6(), new D6());
		System.out.println(l.frequenze());
	}
}
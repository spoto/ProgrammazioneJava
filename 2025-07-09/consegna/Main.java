package it.univr.figures;

// completo, non modificate questa classe

public class Main {

	public static void main(String[] args) throws NoSuchRowException {
		for (int h = 1; h <= 5; h++) {
			System.out.println("triangolo di altezza " + h + ":");
			System.out.println(new Triangle(h));
		}

		for (int r = 1; r <= 16; r += 5) {
			System.out.println("cerchio di raggio " + r + ":");
			System.out.println(new Circle(r));
		}

		for (int h = 1; h <= 5; h++) {
			System.out.println("triangolo di altezza " + h + ", in cornice:");
			System.out.println(new Frame(new Triangle(h)));
		}

		for (int r = 1; r <= 16; r += 5) {
			System.out.println("cerchio di raggio " + r + ", in cornice doppia:");
			System.out.println(new Frame(new Frame(new Circle(r))));
		}

		// ok, nessuna eccezione
		new Frame(new Circle(2)).getRow(5);

		// eccezione, poiché un cerchio di raggio 2 ha le righe da 0 a 3,
		// e aggiungendo una cornice le righe andranno da 0 a 5; quindi 6 è fuori
		new Frame(new Circle(2)).getRow(6);
	}
}

import it.univr.date.Date;

public class Main {

	public static void main(String[] args) {
		Date d1 = new Date(11, 8);
		Date d2 = new Date();

		System.out.println("d1 = " + d1.toString());
		System.out.println("d2 = " + d2.toString());
		d1.setUK();
		System.out.println("d1 = " + d1.toString());
		System.out.println("d2 = " + d2.toString());
		d1.setIT();
		System.out.println("d1 = " + d1.toString());
		System.out.println("d2 = " + d2.toString());

		System.out.println("d1 precede d2 ? " + d1.precede(d2));
		System.out.println("dall'inizio a d1: " + d1.passatiDallInizioDellAnno());
		System.out.println("dall'inizio a d2: " + d2.passatiDallInizioDellAnno());
		System.out.println("da 1/1/1900 a d1: " + d1.passatiDallInizio());
		System.out.println("da 1/1/1900 a d2: " + d2.passatiDallInizio());
	}

}

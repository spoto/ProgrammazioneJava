import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Polynomial poly1 = new Polynomial(new int[] { -3, 4, 0, 0, -2} );
		Polynomial poly2 = new Polynomial(new int[] { 5, -11, 0, 0 } );
		Polynomial poly3 = new Polynomial(new int[] { 3, -4, 3, 1, -1} );
		Polynomial poly4 = new Polynomial(new int[] { 0, 0, -3, 4, 0, 0, -2} );
		Polynomial poly5 = new Polynomial(new int[] { 4, 2, -1 } );

		System.out.println("poly1: "+ poly1 + " with degree " + poly1.degree());
		System.out.println("poly2: "+ poly2 + " with degree " + poly2.degree());
		System.out.println("poly3: "+ poly3 + " with degree " + poly3.degree());
		System.out.println("poly4: "+ poly4 + " with degree " + poly4.degree());
		System.out.println("poly5: "+ poly5 + " with degree " + poly5.degree());

		Polynomial sum = poly1.add(poly2);
		System.out.println("poly1 + poly2: " + sum + " with degree " + sum.degree());

		sum = poly1.add(poly3);
		System.out.println("poly1 + poly3: " + sum + " with degree " + sum.degree());

		SecondDegreePolynomial poly6 = new SecondDegreePolynomial(4, 2, -1);
		System.out.println(poly6 + " can be 0: " + poly6.canBe0());

		SecondDegreePolynomial poly7 = new SecondDegreePolynomial(4, 2, 3);
		System.out.println(poly7 + " can be 0: " + poly7.canBe0());

		System.out.println(poly7 + " at x = 7 is " + poly7.evaluate(7));

		Set<Polynomial> set = new HashSet<Polynomial>();
		set.add(poly1);
		set.add(poly2);
		set.add(poly3);
		set.add(poly4);
		set.add(poly5);
		set.add(poly6);
		set.add(poly7);

		System.out.println("set: " + set);  // stampa un insieme di 5 polinomi

		// questo è illegale:
		new SecondDegreePolynomial(0, 2, 3);
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println("even:");
		Sequence s1 = new Even();
		print(s1, 100);
		
		System.out.println("factorial");
		Sequence s2 = new Fact();
		print(s2, 10);
		
		System.out.println("fibonacci");
		Sequence s3 = new Fib();
		print(s3, 20);
		
		System.out.println("even times 3:");
		Sequence s4 = new Times(new Even(), 3);
		print(s4, 100);

		System.out.println("even twice:");
		Sequence s5 = new Twice(new Even());
		print(s5, 100);

	}

	/**
	 * Stampa i primi howMany numeri della
	 * sequenza s.
	 * @param s
	 * @param howMany
	 */

	private static void print(Sequence s, int howMany) {
		while (howMany-- > 0)
			System.out.println(s.next());
	}

}

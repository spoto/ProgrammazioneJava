package it.univr.ecommerce;

public class Main {
	public static void main(String[] args) throws MissingProductException {
		Product bike = new Product("bike", 300.0, 7);
		Product phone = new Product("phone", 129.9, 1);

		// il negozio amazing ha disponibili 3 biciclette e 4 telefoni
		Shop amazing = new Shop();
		amazing.add(bike, 3);
		amazing.add(phone, 4);

		Order order1 = new SimpleOrder(amazing, bike, phone, phone);
		Order order2 = new SplitOrder(amazing, phone, bike, phone);
		Order order3 = new SimpleOrder(amazing, bike, phone);
		
		printShipping("FIRST ORDER:", order1.ship());
		printShipping("SECOND ORDER:", order2.ship());
		printShipping("THIRD ORDER:", order3.ship());
	}

	private static void printShipping(String title, Iterable<Shipping> shippings) {
		System.out.println(title + '\n');
		int counter = 1;
		for (Shipping shipping: shippings)
			System.out.println("shipping #" + counter++ + '\n' + shipping);

		System.out.println();
	}
}
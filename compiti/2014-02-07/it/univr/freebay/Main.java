package it.univr.freebay;

public class Main {

	public static void main(String[] args) {
		Cart cart = new Cart();

		Product tv = new Product("Super Baffo", "TV al plasma", 589.99);
		Product cd = new Product("Roberto Malandrino", "CD di Laura Masini", 0.89);
		Product modem = new Product("Giorgio Rubacchioni", "modem ADSL", 30.40);

		cart.addProduct(tv);
		cart.addProducts(modem, cd);
		cart.addProduct(new DiscountedProduct(tv, 13.5));
		cart.addProduct(new DiscountedProduct(new DiscountedProduct(modem, 11.6), 15.9));
		cart.addProduct(tv, 2);

		// un cd offerto come prendi due e paghi tre!
		Product specialOffer = new Buy2Take3Product(cd);
		// ne compriamo sette esemplari
		cart.addProduct(specialOffer, 7);

		System.out.println(cart);

		// non possono scontare un 3 per 2: otterro' un'eccezione a questo punto
		cart.addProduct(new DiscountedProduct(specialOffer, 21.00));
	}
}
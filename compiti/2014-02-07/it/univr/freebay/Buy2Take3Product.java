package it.univr.freebay;

public class Buy2Take3Product extends Product {

	private final Product original;

	public Buy2Take3Product(Product original) {
		super(original);

		if (!original.canBeReduced())
			throw new IllegalArgumentException("cannot reduce the price of " + original);

		this.original = original;
	}

	@Override
	public boolean canBeReduced() {
		// non ammettiamo sconti su queste offerte!
		return false;
	}

	@Override
	public double getPrice(Cart cart) {
		// contiamo quanti prodotti uguali a questo ci sono nel carrello
		int count = 0;
		for (Product product: cart)
			if (product == this)
				count++;

		// uno gratis ogni tre
		int gratis = count / 3;

		// ne paghiamo (count - gratis) e ne otteniamo count. Quindi ognuno costa:
		return original.getPrice(cart) * (count - gratis) / count;
	}
}
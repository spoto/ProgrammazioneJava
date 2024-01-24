package it.univr.freebay;

public class DiscountedProduct extends Product {

	private final Product original;

	private final double discount;

	public DiscountedProduct(Product original, double discount) {
		super(original);

		if (!original.canBeReduced())
			throw new IllegalArgumentException("cannot reduce the price of " + original);

		this.discount = discount;
		this.original = original;
	}

	@Override
	public double getPrice(Cart cart) {
		return original.getPrice(cart) * (100 - discount) / 100;
	}

	@Override
	public String toString() {
		return original.toString() + String.format(" [scontato del %.2f%%]", discount);
	}
}
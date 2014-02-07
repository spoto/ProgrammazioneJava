package it.univr.freebay;

public class Product {

	private final String seller;

	private final String name;

	private final double price;

	public Product(String seller, String name, double price) {
		this.seller = seller;
		this.name = name;
		this.price = price;
	}

	protected Product(Product original) {
		this(original.seller, original.name, original.price);
	}

	public final String getSeller() {
		return seller;
	}

	public final String getName() {
		return name;
	}

	public double getPrice(Cart cart) {
		return price;
	}

	public boolean canBeReduced() {
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}
}
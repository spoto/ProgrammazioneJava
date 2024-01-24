package it.univr.ecommerce;

public class Product {
	private final String name;
	private final double price;
	private final int daysBeforeShipping;

	public Product(String name, double price, int daysBeforeShipping) {
		this.name = name;
		this.price = price;
		this.daysBeforeShipping = daysBeforeShipping;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f euros, available in %d days", name, price, daysBeforeShipping);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Product) {
			Product otherAsProduct = (Product) other;
			return name.equals(otherAsProduct.name) &&
				price == otherAsProduct.price &&
				daysBeforeShipping == otherAsProduct.daysBeforeShipping;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() ^ daysBeforeShipping ^ (int) price;
	}

	public int getDaysBeforeShipping() {
		return daysBeforeShipping;
	}
}
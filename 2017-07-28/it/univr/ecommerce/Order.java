package it.univr.ecommerce;

public abstract class Order {
	private final Shop shop;
	private final Product[] products;

	protected Order(Shop shop, Product... products) {
		this.shop = shop;
		this.products = products;
	}

	protected final Product[] getProducts() {
		return products;
	}

	protected final void buy() throws MissingProductException {
		shop.buy(products);
	}

	public abstract Iterable<Shipping> ship() throws MissingProductException;
}
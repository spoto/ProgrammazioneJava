package it.univr.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Shipping {
	private final List<Product> products = new ArrayList<>();

	Shipping(Iterable<Product> products) {
		for (Product product: products)
			this.products.add(product);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Product product: products) {
			sb.append(product.toString());
			sb.append('\n');
		}

		return sb.toString();
	}
}
package it.univr.freebay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart implements Iterable<Product> {

	private final List<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		products.add(product);
	}

	public void addProducts(Product... products) {
		for (Product product: products)
			addProduct(product);
	}

	public void addProduct(Product product, int howManyTimes) {
		for (int counter = 1; counter <= howManyTimes; counter++)
			addProduct(product);
	}

	@Override
	public String toString() {
		String result = "";

		for (Product product: this)
			result += product + "    " + String.format("%.2f euro", product.getPrice(this)) + ". Venduto da " + product.getSeller() + "\n";

		return result;
	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
package it.univr.ecommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleOrder extends Order {

	public SimpleOrder(Shop shop, Product... products) {
		super(shop, products);
	}

	@Override
	public Iterable<Shipping> ship() throws MissingProductException {
		buy();
		List<Shipping> result = new ArrayList<>();
		result.add(new Shipping(Arrays.asList(getProducts())));

		return result;
	}
}
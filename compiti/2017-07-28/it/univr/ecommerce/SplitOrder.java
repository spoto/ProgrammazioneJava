package it.univr.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitOrder extends Order {

	public SplitOrder(Shop shop, Product... products) {
		super(shop, products);
	}

	@Override
	public Iterable<Shipping> ship() throws MissingProductException {
		buy();

		Map<Integer, List<Product>> buckets = new HashMap<>();
		for (Product product: getProducts()) {
			int days = product.getDaysBeforeShipping();
			buckets.putIfAbsent(days, new ArrayList<>());
			buckets.get(days).add(product);

			// oppure:
			//buckets.computeIfAbsent(days, _days -> new ArrayList<>()).add(product);
		}

		List<Shipping> result = new ArrayList<>();
		for (List<Product> bucket: buckets.values())
			result.add(new Shipping(bucket));

		return result;
	}
}
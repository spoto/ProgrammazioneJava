package it.univr.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	private final Map<Product, Integer> products = new HashMap<>();

	public void add(Product product, int howMany) {
		products.putIfAbsent(product, 0);
		products.put(product, products.get(product) + howMany);
	}

	void buy(Product[] productsToBuy) throws MissingProductException {
		List<Product> removed = new ArrayList<>();

		for (Product product: productsToBuy) {
			Integer available = products.get(product);
			if (available == null || available == 0) {
				// prima reinseriamo i prodotti che avevamo tolto
				for (Product toAdd: removed)
					products.put(toAdd, products.get(toAdd) + 1);

				// adesso possiamo abortire la transazione
				throw new MissingProductException();
			}

			removed.add(product);
			products.put(product, available - 1);
		}
	}
}
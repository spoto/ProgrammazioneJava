package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public class PizzaWithout extends AbstractPizza {
	private final Pizza base;
	private final String removedIngredient;
	private final int priceReduction;

	public PizzaWithout(Pizza base, String removedIngredient, int priceReduction) {
		if (!base.getIngredients().contains(removedIngredient))
			throw new IllegalPizzaModificationException("Pizza" + base + " doe snot contain " + removedIngredient);

		this.base = base;
		this.removedIngredient = removedIngredient;
		this.priceReduction = priceReduction;
	}

	@Override
	public String toString() {
		return base + " without " + removedIngredient;
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>(base.getIngredients());
		result.remove(removedIngredient);

		return result;
	}

	@Override
	public int getPrice() {
		return base.getPrice() - priceReduction;
	}
}
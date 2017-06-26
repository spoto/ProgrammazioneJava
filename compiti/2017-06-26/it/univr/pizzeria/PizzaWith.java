package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public class PizzaWith extends AbstractPizza {
	private final Pizza base;
	private final String addedIngredient;
	private final int extraPrice;

	public PizzaWith(Pizza base, String addedIngredient, int extraPrice) {
		if (base.getIngredients().contains(addedIngredient))
			throw new IllegalPizzaModificationException("Pizza" + base + " contains " + addedIngredient + " already");

		this.base = base;
		this.addedIngredient = addedIngredient;
		this.extraPrice = extraPrice;
	}

	@Override
	public String toString() {
		return base + " with " + addedIngredient;
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>(base.getIngredients());
		result.add(addedIngredient);

		return result;
	}

	@Override
	public int getPrice() {
		return base.getPrice() + extraPrice;
	}
}
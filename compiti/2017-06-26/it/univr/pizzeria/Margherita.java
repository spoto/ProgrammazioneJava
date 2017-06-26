package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public final class Margherita extends AbstractPizza {
	final static Margherita INSTANCE = new Margherita();
	private Margherita() {}

	@Override
	public String toString() {
		return "Margherita";
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>();
		result.add("tomato");
		result.add("mozzarella");
	
		return result;
	}

	@Override
	public int getPrice() {
		return 5;
	}
}
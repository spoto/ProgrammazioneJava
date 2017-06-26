package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public final class Formaggi extends AbstractPizza {
	final static Formaggi INSTANCE = new Formaggi();
	private Formaggi() {}

	@Override
	public String toString() {
		return "Quattro Formaggi";
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>();
		result.add("mozzarella");
		result.add("parmesan");
		result.add("gorgonzola");
	
		return result;
	}

	@Override
	public int getPrice() {
		return 8;
	}
}
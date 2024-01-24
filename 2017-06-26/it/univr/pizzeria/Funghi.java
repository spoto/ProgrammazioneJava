package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public final class Funghi extends AbstractPizza {
	final static Funghi INSTANCE = new Funghi();
	private Funghi() {}

	@Override
	public String toString() {
		return "Funghi";
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>();
		result.add("tomato");
		result.add("mozzarella");
		result.add("mushrooms");
	
		return result;
	}

	@Override
	public int getPrice() {
		return 7;
	}
}
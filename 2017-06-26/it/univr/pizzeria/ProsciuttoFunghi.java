package it.univr.pizzeria;

import java.util.SortedSet;
import java.util.TreeSet;

public class ProsciuttoFunghi extends AbstractPizza {
	final static ProsciuttoFunghi INSTANCE = new ProsciuttoFunghi();
	private ProsciuttoFunghi() {}

	@Override
	public String toString() {
		return "Prosciutto & Funghi";
	}

	@Override
	public SortedSet<String> getIngredients() {
		SortedSet<String> result = new TreeSet<>();
		result.add("tomato");
		result.add("mozzarella");
		result.add("mushrooms");
		result.add("ham");
	
		return result;
	}

	@Override
	public int getPrice() {
		return 8;
	}
}
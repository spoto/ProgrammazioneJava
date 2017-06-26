package it.univr.pizzeria;

import java.util.SortedSet;

public interface Pizza extends Comparable<Pizza> {
	public SortedSet<String> getIngredients();
	public int getPrice();
}
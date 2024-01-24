package it.univr.pizzeria;

public abstract class AbstractPizza implements Pizza {

	@Override
	public final boolean equals(Object other) {
		return other instanceof Pizza && getIngredients().equals(((Pizza) other).getIngredients());
	}

	@Override
	public final int hashCode() {
		return getIngredients().hashCode();
	}

	@Override
	public final 
	int compareTo(Pizza other) {
	    // sfruttiamo il fatto che il toString() degli insiemi ritorna la conctenazione degli elementi
		return getIngredients().toString().compareTo(((Pizza) other).getIngredients().toString());
	}

	public abstract String toString();
}

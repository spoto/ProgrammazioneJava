package it.univr.pizzeria;

public class IllegalPizzaModificationException extends RuntimeException {
	public IllegalPizzaModificationException(String message) {
		super(message);
	}
}
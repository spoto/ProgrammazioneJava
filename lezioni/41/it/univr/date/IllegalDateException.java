package it.univr.date;

public class IllegalDateException extends Exception {

	public IllegalDateException(String messaggio) {
		super(messaggio);
	}

	public IllegalDateException() {
		super("illegal date");
	}
}
 
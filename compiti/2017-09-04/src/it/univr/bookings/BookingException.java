package it.univr.bookings;

public abstract class BookingException extends Exception {
	protected BookingException(String message) {
		super(message);
	}
}
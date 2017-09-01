package it.univr.bookings;

public abstract class QuoteException extends BookingException {
	protected QuoteException(String message) {
		super(message);
	}
}
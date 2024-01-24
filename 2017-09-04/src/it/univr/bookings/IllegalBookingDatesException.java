package it.univr.bookings;

public class IllegalBookingDatesException extends QuoteException {
	public IllegalBookingDatesException() {
		super("illegal booking dates");
	}
}
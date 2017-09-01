package it.univr.bookings;

public class FlightSoldOutException extends QuoteException {
	public FlightSoldOutException() {
		super("flight soldout");
	}
}
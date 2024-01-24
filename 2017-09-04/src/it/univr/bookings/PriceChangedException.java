package it.univr.bookings;

public class PriceChangedException extends BookingException {
	public PriceChangedException() {
		super("flight price has changed");
	}
}
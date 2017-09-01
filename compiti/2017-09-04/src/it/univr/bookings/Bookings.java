package it.univr.bookings;

import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Bookings {
	private final Date start, end;
	private final int minimalPrice, maximalPrice;
	private final Fleet fleet;

	private final SortedMap<Date, Integer> seatsBooked = new TreeMap<>();

	public Bookings(Date start, Date end, int minimalPrice, int maximalPrice, Fleet fleet) {
		this.start = start;
		this.end = end;
		this.minimalPrice = minimalPrice;
		this.maximalPrice = maximalPrice;
		this.fleet = fleet;

		if (start.compareTo(end) > 0)
			throw new IllegalArgumentException("Start date cannot occur after end date");

		if (minimalPrice < 0 || minimalPrice > maximalPrice)
			throw new IllegalArgumentException("minimalPrice cannot be higher than maximalPrice, nor negative");
	}

	public int getQuoteFor(Date when) throws QuoteException {
		if (when.compareTo(start) < 0 || when.compareTo(end) > 0)
			throw new IllegalBookingDatesException();

		Aircraft aircraft = fleet.getAircraftFor(when);
		int alreadyBooked = getSeatsBooked(when);
		int capacity = aircraft.getCapacity();
		if (alreadyBooked == capacity)
			throw new FlightSoldOutException();

		return minimalPrice + alreadyBooked * (maximalPrice - minimalPrice) / (capacity - 1);
	}

	public void book(Date when, int price) throws BookingException {
		if (price != getQuoteFor(when))
			throw new PriceChangedException();

		seatsBooked.put(when, getSeatsBooked(when) + 1);
	}

	public int book(Date when) throws BookingException {
		int price = getQuoteFor(when);
		book(when, price);

		return price;
	}

	private int getSeatsBooked(Date when) {
		seatsBooked.putIfAbsent(when, 0);
		return seatsBooked.get(when);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Date when: seatsBooked.keySet())
			sb.append(when + ": " + getSeatsBooked(when) + " [" + fleet.getAircraftFor(when) + "]\n");

		return sb.toString();
	}
}
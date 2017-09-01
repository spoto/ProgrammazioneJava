package it.univr.bookings;

public interface Fleet {
	Aircraft getAircraftFor(Date when);
}
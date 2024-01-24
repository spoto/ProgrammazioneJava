package it.univr.bookings;

public class Aircraft {
	private final String name;
	private final int capacity;

	public Aircraft(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return name;
	}
}
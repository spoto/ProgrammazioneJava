package it.univr.hairbnb;

public class NoRoomAvailableException extends RuntimeException {
	public NoRoomAvailableException() {
		super("No room is available for the selected criteria");
	}
}
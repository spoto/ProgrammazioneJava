package it.univr.paranoid;

public class AppNotSupportedException extends RuntimeException {

	public AppNotSupportedException() {
		super("This app requires a newer OS version");
	}
}

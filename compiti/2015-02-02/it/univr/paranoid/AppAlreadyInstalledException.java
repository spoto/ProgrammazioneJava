package it.univr.paranoid;

public class AppAlreadyInstalledException extends RuntimeException {

	public AppAlreadyInstalledException() {
		super("This app is already installed");
	}
}

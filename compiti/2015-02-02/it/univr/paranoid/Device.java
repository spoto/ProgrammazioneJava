package it.univr.paranoid;

import java.util.SortedSet;
import java.util.TreeSet;

public class Device {
	public final OS os;
	private final SortedSet<App> apps = new TreeSet<App>();

	public Device(OS os) {
		this.os = os;
	}

	public void install(App app) {
		// non possiamo installare app che richiedono una versione
		// del sistema successiva a quella di questo dispositivo
		if (os.compareTo(app.MIN_OS) < 0)
			throw new AppNotSupportedException();

		// se l'app è già installata, possiamo solo sostituirla con una versione successiva
		for (App installed: apps)
			if (installed.getName().equals(app.getName()))
				if (installed.getVersion() >= app.getVersion())
					throw new AppAlreadyInstalledException();
				else {
					apps.remove(installed);
					break;
				}

		apps.add(app);
	}

	public void deInstall(App app) {
		apps.remove(app);
	}

	public SortedSet<App> getInstalledApps() {
		return apps;
	}
}
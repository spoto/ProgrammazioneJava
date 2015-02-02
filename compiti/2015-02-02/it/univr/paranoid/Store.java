package it.univr.paranoid;

import java.util.SortedSet;
import java.util.TreeSet;

public class Store {
	private final SortedSet<App> apps = new TreeSet<App>();
	private final String name;

	public Store(String name) {
		this.name = name;
	}

	public void add(App app) {
		apps.add(app);
	}

	@Override
	public String toString() {
		String result = "Store " + name + ":\n\n";
		for (App app: apps)
			result += app + "\n";
		
		return result;
	}

	/**
	 * Restituisce le app compatibili col dispositivo indicato. Se più versioni di
	 * una stessa app sono compatibili col dispositivo, restituisce solo la versione più recente.
	 * 
	 * @param device il dispositivo
	 * @return le app compatibili con device
	 */
	public SortedSet<App> getAppsFor(Device device) {
		SortedSet<App> result = new TreeSet<App>();
		App previous = null;
		for (App app: apps)
			if (app.MIN_OS.compareTo(device.os) <= 0) {
				result.add(app);
				// se l'app precedentemente inserita nel risultato ha lo stesso nome
				// di quella che stiamo inserendo, essendo result ordinato, vorrà
				// dire che quella che stiamo inserendo è una versione più aggiornata,
				// per cui eliminiamo la precedente dal risultato
				if (previous != null && previous.getName().equals(app.getName()))
					result.remove(previous);

				previous = app;
			}
			
		return result;
	}
}
package it.univr.paranoid;

public class App implements Comparable<App> {
	private final String name;
	private final int version; // 1, 2, 3...
	public final OS MIN_OS;

	public App(String name, OS minOS, int version) {
		this.name = name;
		this.MIN_OS = minOS;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return name + " version " + version;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof App && ((App) other).name.equals(name) && ((App) other).version == version;
	}

	@Override
	public int hashCode() {
		return name.hashCode() ^ version;
	}

	@Override
	public int compareTo(App other) {
		int diff = name.compareTo(other.name);
		if (diff != 0)
			return diff;
		else
			return version - other.version;
	}
}
package it.univr.rent;

public abstract class AbstractModel implements Model {
	private final String name;
	private final int pricePerDay;

	protected AbstractModel(String name, int pricePerDay) {
		this.name = name;
		this.pricePerDay = pricePerDay;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public final int pricePerDay() {
		return pricePerDay;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public final int compareTo(Model other) {
		int diff = pricePerDay - other.pricePerDay();
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.getName());
	}

	public abstract boolean equals(Object other);

	@Override
	public int hashCode() {
		return name.hashCode() ^ pricePerDay;
	}
}

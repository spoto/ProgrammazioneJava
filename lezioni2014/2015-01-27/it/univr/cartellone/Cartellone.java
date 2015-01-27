package it.univr.cartellone;

public abstract class Cartellone implements Iterable<Train> {

	@Override
	public final String toString() {
		String result = "";

		for (Train train: this)
			result += train + "\n";

		return result;
	}
}
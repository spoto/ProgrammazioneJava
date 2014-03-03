package it.univr.cartellone;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class CartelloneModificabile extends Cartellone {

	private final SortedSet<Train> trains = new TreeSet<Train>();

	public CartelloneModificabile() {
	}

	public void add(Train train) {
		trains.add(train);
	}

	public void add(Iterable<Train> trains) {
		for (Train train: trains)
			add(train);
	}

	public void add(Train... trains) {
		for (Train train: trains)
			add(train);
	}

	@Override
	public Iterator<Train> iterator() {
		return trains.iterator();
	}
}
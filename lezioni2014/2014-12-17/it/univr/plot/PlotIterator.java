package it.univr.plot;

import java.util.ArrayList;
import java.util.Iterator;

public class PlotIterator implements Iterator<Sample> {

	private final ArrayList<Sample> samples;
	private int cursor;

	public PlotIterator(ArrayList<Sample> samples) {
		this.samples = samples;
	}

	@Override
	public boolean hasNext() {
		return cursor < samples.size();
	}

	@Override
	public Sample next() {
		return samples.get(cursor++);
	}

	@Override
	public void remove() {
	}
}
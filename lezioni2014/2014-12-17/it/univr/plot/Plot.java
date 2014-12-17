package it.univr.plot;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Plot implements Iterable<Sample> {
	private ArrayList<Sample> samples = new ArrayList<Sample>();

	protected Plot() {
	}

	@Override
	public Iterator<Sample> iterator() {
		return samples.iterator();  // delegation
		//new PlotIterator(samples);
	}

	public final void add(Sample sample) throws DuplicatedSampleException, InconsistentSampleSizeException {
		for (Sample sample2: samples)
			if (sample2.getName().equals(sample.getName()))
				throw new DuplicatedSampleException();
			else if (sample2.getSize() != sample.getSize())
				throw new InconsistentSampleSizeException();

		samples.add(sample);
	}

	public final void add(Plot plot) throws DuplicatedSampleException, InconsistentSampleSizeException {
		for (Sample sample: plot.getSamples())
			add(sample);
	}

	public final float getMax() {
		float max = 0f;
		for (Sample sample: samples)
			max = Math.max(max, sample.getMax());

		return max;
	}

	public final boolean equals(Object other) {
		return other instanceof Plot
			&& samples.equals(((Plot) other).getSamples());
	}

	protected final ArrayList<Sample> getSamples() {
		return samples;
	}

	public abstract String toString();
}
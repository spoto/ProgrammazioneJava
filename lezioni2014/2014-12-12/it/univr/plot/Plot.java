package it.univr.plot;

import java.util.Arrays;

public abstract class Plot {
	private Sample[] samples = new Sample[0];

	protected Plot() {
	}

	public final void add(Sample sample) throws DuplicatedSampleException, InconsistentSampleSizeException {
		for (Sample sample2: samples)
			if (sample2.getName().equals(sample.getName()))
				throw new DuplicatedSampleException();
			else if (sample2.getSize() != sample.getSize())
				throw new InconsistentSampleSizeException();

		samples = Arrays.copyOf(samples, samples.length + 1);
		samples[samples.length - 1] = sample;
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
			&& Arrays.equals(samples, ((Plot) other).getSamples());
	}

	protected final Sample[] getSamples() {
		return samples;
	}

	public abstract String toString();
}
import java.util.Arrays;

public abstract class Plot {
	private Sample[] samples;

	protected Plot() {
		samples = new Sample[0];
	}

	public final void add(Sample sample) throws DuplicatedSampleException, InconsistentSampleSizeException {
		for (Sample s: samples)
			if (s.getName().equals(sample.getName()))
				throw new DuplicatedSampleException();

		if (samples.length > 0 && samples[0].getSize() != sample.getSize())
			throw new InconsistentSampleSizeException();
		
		Sample[] temp = samples;
		samples = new Sample[temp.length + 1];
		System.arraycopy(temp, 0, samples, 0, temp.length);
		samples[temp.length] = sample;
	}

	public final void add(Plot plot) throws DuplicatedSampleException, InconsistentSampleSizeException {
		for (Sample sample: plot.samples)
			add(sample);
	}

	public final float getMax() { // il massimo valore fra tutte le sample
		float max = 0f;
		for (Sample sample: samples)
			max = Math.max(max, sample.getMax());
		return max;
	}

	public final boolean equals(Object other) {
		return other instanceof Plot && Arrays.equals(((Plot) other).samples, samples);
	}

	protected final Sample[] getSamples() {
		return samples;
	}

	public abstract String toString();
}
import java.util.HashSet;
import java.util.Set;

public abstract class Plot {

	private final Set<Sample> samples = new HashSet<Sample>();

	public final void add(Sample sample) throws DuplicatedSampleException, InconsistentSampleSizeException  {
		// prima controlliamo se c'è già una sample dello stesso nome
		// o se la sample ha una dimensione diversa dalle sample che
		// già ci sono in questo plot
		String name = sample.getName();
		int size = sample.getSize();
		for (Sample mySample: samples)
			if (mySample.getName().equals(name))
				throw new DuplicatedSampleException(name);
			else if (mySample.getSize() != size)
				throw new InconsistentSampleSizeException(size);

		// se non c'è, aggiungiamo la sample
		samples.add(sample);
	}

	public final void add(Plot plot) throws DuplicatedSampleException, InconsistentSampleSizeException {
		// aggiungiamo a questo plot tutte le sample dell'altro
		for (Sample sample: plot.samples)
			add(sample);
	}

	public final float getMax() {
		float max = 0f;
		for (Sample sample: samples)
			for (int pos = 0; pos < sample.getSize(); pos++)
				max = Math.max(max, sample.getValue(pos));

		return max;
	}

	@Override
	public final boolean equals(Object other) {
		// ovviamente si può anche scrivere due cicli annidati per controllare gli elementi
		// dei due insiemi di samples, ma è più semplice dire che i due insiemi devono essere equals
		return other instanceof Plot && ((Plot) other).samples.equals(samples);
	}

	@Override
	public final int hashCode() {
		return samples.hashCode();  // va bene anche samples.size() ma ci sono tante altre alternative corrette
	}

	protected final Set<Sample> getSamples() {
		return samples;
	}

	@Override
	public abstract String toString();
}

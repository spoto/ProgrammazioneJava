import java.util.Arrays;

public class Sample {
	private final String name;
	private final float[] values;

	public Sample(String name, float[] values) {
		this.name = name;
		this.values = values;

		for (float f: values)
			if (f < 0f)
				throw new IllegalArgumentException("samples cannot hold negative values");
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return values.length;
	}

	public float getValue(int pos) {
		return values[pos];
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Sample) {
			Sample otherSample = (Sample) other;
			// la funzione di libreria java.util.Arrays.equals ci risulta molto
			// comoda, ma ovviamente si può anche usare un ciclo che controlla l'uguaglianza
			// della lunghezza degli array e dei loro elementi alla stessa posizione
			return otherSample.name.equals(name) && Arrays.equals(otherSample.values, values);
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
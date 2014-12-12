package it.univr.plot;

import java.util.Arrays;

public class Sample {
	private final String name;
	private final float[] values;

	public Sample(String name, float[] values) {
		this.name = name;
		this.values = values;

		for (float f: values)
			if (f < 0.0f)
				throw new IllegalArgumentException();
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return values.length;
	}

	public float getMax() {
		float max = 0.0f;
		for (float f: values)
			if (f > max)
				max = f;

		return max;
	}

	public float getValue(int pos) {
		return values[pos];
	}

	public boolean equals(Object other) {
		return other instanceof Sample
				&& name.equals(((Sample) other).name)
				&& Arrays.equals(values, ((Sample) other).values);
	}
}
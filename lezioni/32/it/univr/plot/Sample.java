package it.univr.plot;

import java.util.Arrays;

public class Sample {
	private final String name;
	private final float[] values;

	public Sample(String name, float[] values) {
		this.name = name;
		this.values = values;

		for (float f: values)
			if (f < 0f)
				throw new IllegalArgumentException("all values must be non-negative in a sample");
	}

	public String getName() {
		return name;
	}

	public float getMax() {
		float max = 0f;
		for (float f: values)
			max = Math.max(max, f);

		return max;
	}
	public int getSize() {
		return values.length;
	}

	public float getValue(int pos) {
		return values[pos];
	}

	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass())
			return false;

		Sample otherAsSample = (Sample) other;
		return name.equals(otherAsSample.name) &&
				Arrays.equals(values, otherAsSample.values);
	}
}
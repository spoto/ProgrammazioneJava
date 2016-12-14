import java.util.Arrays;

public class Sample {
	private final String name;
	private final float[] values;

	public Sample(String name, float[] values) {
		this.name = name;
		this.values = values;
		
		for (float v: values)
			if (v < 0)
				throw new IllegalArgumentException();
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return values.length;
	}

	public float getMax() {
		float result = Float.NEGATIVE_INFINITY;

		for (float v: values)
			if (v > result)
				result = v;
		
		return result;
	}

	public float getValue(int pos) {
		return values[pos];
	}

	public boolean equals(Object other) {
		return other instanceof Sample && ((Sample) other).name.equals(name)
			&& Arrays.equals(((Sample) other).values, values);
	}
}
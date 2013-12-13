package it.univr.plot;

public class SequentialPlot extends Plot {

	public SequentialPlot() {
		super();
	}

	@Override
	public String toString() {
		String alternatives = "*@$";
		int alternative = 0;
		float max = getMax();

		String result = "";

		for (Sample sample: getSamples()) {
			result += sample.getName() + ":\n";

			for (int pos = 0; pos < sample.getSize(); pos++)
				result += "| "
					+ bar(alternatives.charAt(alternative), sample.getValue(pos), max)
					+ " (" + sample.getValue(pos) + ")\n";

			result += '\n';

			alternative = (alternative + 1) % alternatives.length();
		}

		return result;
	}

	private String bar(char character, float value, float max) {
		String result = "";

		int len = (int) (40 * value / max);
		for (int counter = 0; counter < len; counter++)
			result += character;

		return result;
	}
}
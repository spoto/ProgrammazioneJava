package it.univr.plot;

public class AlternatePlot extends Plot {

	public AlternatePlot() {
		super();
	}

	@Override
	public String toString() {
		String result = "";

		if (getSamples().length != 0) {
			int size = getSamples()[0].getSize();
			float max = getMax();
			String alternatives = "*@$";

			for (int counter = 0; counter < size; counter++) {
				int alternative = 0;
				for (Sample sample: getSamples()) {
					result += String.format("%15s| %s (%.1f)\n",
								sample.getName(),
								bar(alternatives.charAt(alternative), sample.getValue(counter), max),
								sample.getValue(counter));
	
					alternative = (alternative + 1) % alternatives.length();
				}
	
				result += '\n';
			}
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
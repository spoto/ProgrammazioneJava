package it.univr.plot;

public class SequentialPlot extends Plot {

	@Override
	public String toString() {
		String result = "";
		int counter = 0;
		String[] all = { "****************************************",
					     "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
					     "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" };

		for (Sample sample: getSamples()) {
			result += sample.getName() + ":\n";
			for (int pos = 0; pos < sample.getSize(); pos++) {
				float value =  sample.getValue(pos);
				int length = (int) (40 * value / getMax());

				result += String.format("| %." + length + "s (%.1f)\n", all[counter], value);
			}

			counter = ++counter % 3;
			result += "\n";
		}

		return result;
	}
}
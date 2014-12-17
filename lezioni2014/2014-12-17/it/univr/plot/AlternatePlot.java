package it.univr.plot;

public class AlternatePlot extends Plot {

	@Override
	public String toString() {
		String result = "";
		String[] all = { "****************************************",
					     "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
					     "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" };

		if (!getSamples().isEmpty()) {
			for (int pos = 0; pos < getSamples().get(0).getSize(); pos++) {
				int counter = 0;

				for (Sample sample: getSamples()) {
					float value =  sample.getValue(pos);
					int length = (int) (40 * value / getMax());

					result += String.format("%15s | %." + length + "s (%.1f)\n", sample.getName(), all[counter], value);					
					counter = ++counter % 3;
				}

				result += "\n";
			}
		}

		return result;
	}
}
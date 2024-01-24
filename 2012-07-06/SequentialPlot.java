
public class SequentialPlot extends Plot {

	@Override
	public String toString() {
		String result = "";
		String chars = "*@$";
		int choice = 0;

		for (Sample sample: getSamples()) {
			result += toStringSample(sample, chars.charAt(choice++));
			choice = choice % chars.length();
		}

		return result;
	}

	private String toStringSample(Sample sample, char c) {
		String result = sample.getName() + ":\n";
		float max = getMax();

		for (int pos = 0; pos < sample.getSize(); pos++) {
			float value = sample.getValue(pos);
			result += "| " + repeat((int) (value / max * 40f), c) + " (" + value + ")\n";
		}

		result += "\n";

		return result;
	}

	private String repeat(int numberOfTime, char c) {
		String result = "";
		while (numberOfTime-- > 0)
			result += c;

		return result;
	}
}

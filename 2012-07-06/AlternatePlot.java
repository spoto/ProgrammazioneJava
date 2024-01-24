
public class AlternatePlot extends Plot {

	@Override
	public String toString() {
		String result = "";

		if (!getSamples().isEmpty()) {
			// determiniamo quanti numeri ci sono in ciascuna sample
			int size = getSamples().iterator().next().getSize();
			float max = getMax();

			String chars = "*@$";

			for (int pos = 0; pos < size; pos++) {
				int choice = 0;

				for (Sample sample: getSamples()) {
					float value = sample.getValue(pos);
					String name = sample.getName();
					name += repeat(15 - name.length(), ' ');
					char c = chars.charAt(choice++);
					choice = choice % chars.length();

					result += name + " | " + repeat((int) (value / max * 40f), c) + " (" + value + ")\n";
				}

				result += "\n";
			}
		}

		return result;
	}

	private String repeat(int numberOfTime, char c) {
		String result = "";
		while (numberOfTime-- > 0)
			result += c;

		return result;
	}
}

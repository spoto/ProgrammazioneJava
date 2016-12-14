import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class WordCounter {
	public final int count;

	public WordCounter(String filename) throws FileNotFoundException, IOException {
		int count = 0;

		try (BufferedReader r = new BufferedReader(new FileReader(filename))) {
			String s;
			do {
				s = r.readLine();
				if (s != null)
					count += numberOfWordsIn(s);
			}
			while (s != null);
		}

		this.count = count;
	}

	private int numberOfWordsIn(String s) {
		int counter = 0;
		String[] words = s.split("[ -]");
		for (String word: words)
			if (!word.isEmpty())
				counter++;

		return counter;
	}
}

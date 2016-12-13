import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PrintFile {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {

		try (BufferedReader r = new BufferedReader
					(new FileReader("file.txt"))) {

			String s;

			do {
				s = r.readLine();
				if (s != null)
					System.out.println(s);
			}
			while (s != null);
		}
	}
}

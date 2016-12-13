import it.univr.date.Date;
import it.univr.date.DateFormatException;
import it.univr.date.NonExistentDateException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessDates {

	public static void main(String[] args) {
		Date[] dates;
		
		try {
			dates = readDates("dates.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("Il file dates.txt non esiste");
			return;
		}
		catch (IOException e) {
			System.out.println("Problema di accesso al disco");
			return;
		}

		sortDates(dates);

		try {
			writeDates(dates, "dates_sorted.txt");
		}
		catch (IOException e) {
			System.out.println("Problema di scrittura in dates_sorted.txt");
			return;
		}
	}

	private static Date[] readDates(String filename)
		throws FileNotFoundException, IOException {

		List<Date> dates = new ArrayList<>();

		try (BufferedReader r = new BufferedReader
				(new FileReader(filename))) {

			String s;

			do {
				s = r.readLine();
				
				if (s != null)
					try {
						Date date = convertIntoDate(s);
						dates.add(date);
					}
					catch (DateFormatException e) {
						System.out.println("la riga " + s
							+ " non è convetibile in una data");
					}
			}
			while (s != null);
		}

		return dates.toArray(new Date[dates.size()]);
	}

	private static Date convertIntoDate(String s) {
		String[] components = s.split("/");
		if (components.length == 3) {
			try {
				int g = Integer.parseInt(components[0]);
				int m = Integer.parseInt(components[1]);
				int a = Integer.parseInt(components[2]);

				try {
					return new Date(g, m, a);
				}
				catch (NonExistentDateException e) {
					throw new DateFormatException();
				}
			}
			catch (NumberFormatException e) {
				throw new DateFormatException();
			}
		}
		else {
			throw new DateFormatException();
		}
	}

	private static void sortDates(Date[] dates) {
		while (swap(dates));
	}

	private static boolean swap(Date[] dates) {
		boolean swapped = false;

		for (int pos = 0; pos < dates.length - 1; pos++)
			if (dates[pos + 1].precede(dates[pos])) {
				Date temp = dates[pos + 1];
				dates[pos + 1] = dates[pos];
				dates[pos] = temp;
				swapped = true;
			}

		return swapped;
	}

	private static void writeDates
	 	(Date[] dates, String filename) throws IOException {

		try (FileWriter w = new FileWriter(filename)) {
			for (Date date: dates) {
				w.write(date.toString());
				w.write("\n");
			}
		}
	}
}

package it.univr.dates;

//CONSEGNATE Dates.java INVIANDOLO A fausto.spoto@univr.it

//Create un nuovo progetto Java con un package it.univr.dates dentro il quale
//copiate Date.java, Dates.java e Main.java.

//Completate Dates.java

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public interface Dates extends Iterable<Date> {

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono le date
	 * dell'anno indicato, in ordine, dal primo gennaio al 31 dicembre.
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates of(int year) {
		return new Dates() {

			@Override
			public Iterator<Date> iterator() {
				return new Iterator<Date>() {
					private Date cursor = new Date(1, 1, year);
					private final Date end = new Date(31, 12, year);

					@Override
					public boolean hasNext() {
						return cursor.compareTo(end) <= 0;
					}

					@Override
					public Date next() {
						Date result = cursor;
						cursor = cursor.next();
						return result;
					}
				};
			}
		};
	}

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono le date
	 * dal primo gennaio dell'anno indicato in poi, in ordine.
	 * Si noti che sono in numero infinito.
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates from(int year) {
		return new Dates() {

			@Override
			public Iterator<Date> iterator() {
				return new Iterator<Date>() {
					private Date cursor = new Date(1, 1, year);

					@Override
					public boolean hasNext() {
						return true;
					}

					@Override
					public Date next() {
						Date result = cursor;
						cursor = cursor.next();
						return result;
					}
				};
			}
		};
	}

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono howMany date
	 * casuali tra il 2000 e il 2100 (sono ammesse ripetizioni).
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates random(int howMany) {
		return new Dates() {
			private int counter = 0;

			@Override
			public Iterator<Date> iterator() {
				return new Iterator<Date>() {

					@Override
					public boolean hasNext() {
						return counter < howMany;
					}

					@Override
					public Date next() {
						counter++;
						return new Date();
					}
				};
			}
		};
	}

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono howMany date
	 * casuali tra il 2000 e il 2100, con la garanzia che sono tutte diverse.
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates randomDistinct(int howMany) {
		return new Dates() {
			private int counter = 0;
			private final Set<Date> seen = new HashSet<>();

			@Override
			public Iterator<Date> iterator() {
				return new Iterator<Date>() {

					@Override
					public boolean hasNext() {
						return counter < howMany;
					}

					@Override
					public Date next() {
						Date result;
						
						do {
							result = new Date();
						}
						while (seen.contains(result));

						counter++;
						seen.add(result);
						return result;
					}
				};
			}
		};
	}
}
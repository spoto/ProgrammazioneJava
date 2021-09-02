// CI SONO TRE METODI DA COMPLETARE

package it.univr.dates;

import java.util.Iterator;

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
		// COMPLETATE
		return null;
	}

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono howMany date
	 * casuali tra il 2000 e il 2100 (sono ammesse ripetizioni).
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates random(int howMany) {
		// COMPLETATE
		return null;
	}

	/**
	 * Restituisce un oggetto Dates la cui iterazione sono howMany date
	 * casuali tra il 2000 e il 2100, con la garanzia che sono tutte diverse.
	 * 
	 * @param year l'anno di cui voglio le date
	 * @return l'oggetto Dates restituito
	 */
	public static Dates randomDistinct(int howMany) {
		// COMPLETATE
		return null;
	}
}
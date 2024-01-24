package it.univr.agenda;

/**
 * Una data con rappresentazione italiana, del tipo 04/02/2019 (giorno/mese/anno).
 */
public class ItalianDate extends Date {

	/**
	 * I giorni in ciascun mese (gennaio -> dicembre), senza considerare gli anni bisestili.
	 */
	private final static int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/**
	 * Costruisce una data con notazione italiana.
	 * 
	 * @param day il giorno del mese, da 1 a 31
	 * @param month il mese, da 1 a 12
	 * @param year l'anno, da 1900 in poi
	 * @throws IllegalArgumentException se day/month/year non fosse una data valida
	 *                                  dal 1900 in poi, considerando anche gli anni bisestile
	 */
	public ItalianDate(int day, int month, int year) {
		super(0); // TODO
	}

	/**
	 * Determina se l'anno indicato e' bisestile.
	 * 
	 * @param year l'anno
	 */
	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	/**
	 * Restituisce il numero di giorni dell'anno indicato.
	 * 
	 * @param year l'anno
	 * @return 365 o 366
	 */
	private static int daysInYear(int year) {
		return isLeapYear(year) ? 366 : 365;
	}

	/**
	 * Restituisce il numero di giorni di un mese di un anno.
	 * Considera gli anni bisestili.
	 * 
	 * @param month il mese, da 1 a 12
	 * @param year l'anno, dal 1900 in poi
	 * @return 28, 29, 30 o 31
	 */
	private static int daysInMonth(int month, int year) {
		if (month == 2 && isLeapYear(year))
			return 29;
		else
			return daysInMonth[month - 1];
	}

	/**
	 * Restituisce il numero di giorni dal 1 gennaio 1900 (incluso) a day/month/year (escluso).
	 * 
	 * @param day il giorno
	 * @param month il mese
	 * @param year l'anno
	 * @return il numero di giorni dall'1 gennaio 1900 (incluso) a day/month/year (escluso)
	 * @throws IllegalArgumentException se day/month/year non fosse una data valida,
	 *                                  considerando anche gli anni bisestile
	 */
	private static int daysAfterStartOf1900(int day, int month, int year) {
		return 0; // TODO. A cosa potrebbe servirvi questo metodo privato?
	}

	/**
	 * Restituisce l'anno di questa data.
	 * 
	 * @return dal 1900 in poi
	 */
	private int getYear() {
		int year = 1900;
		for (int daysAfterStartOf1900 = 0; this.daysAfterStartOf1900 - daysAfterStartOf1900 >= daysInYear(year); daysAfterStartOf1900 += daysInYear(year++)); 
		
		return year;
	}

	/**
	 * Restituisce il mese di questa data.
	 * 
	 * @return da 1 a 12
	 */
	private int getMonth() {
		int year = 1900;
		int remainingDays;
		for (remainingDays = daysAfterStartOf1900; remainingDays >= daysInYear(year); remainingDays -= daysInYear(year++)); 

		int month;
		for (month = 1; remainingDays >= daysInMonth(month, year); remainingDays -= daysInMonth(month++, year));

		return month;
	}

	/**
	 * Restituisce il giorno di questa data.
	 * 
	 * @return da 1 a 31
	 */
	private int getDay() {
		int year = 1900;
		int remainingDays;
		for (remainingDays = daysAfterStartOf1900; remainingDays >= daysInYear(year); remainingDays -= daysInYear(year++)); 

		int month;
		for (month = 1; remainingDays >= daysInMonth(month, year); remainingDays -= daysInMonth(month++, year));

		return remainingDays + 1;
	}

	/**
	 * Restituisce una stringa che descrive questa data.
	 * 
	 * @return una stringa del tipo gg/mm/aaaa, in cui giorno e mese sono sempre su due cifre
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	@Override
	public ItalianDate after(int days) {
		return null; // TODO
	}
}

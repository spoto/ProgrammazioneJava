package it.univr.agenda;

// Ci sono 4 TODO

/**
 * Una data con rappresentazione trimestrale. Per esempio 35Q1 2019 e' il
 * 35-esimo giorno del primo trimestre del 2019, cioe' il 4 febbraio 2019.
 * Invece 01Q4 2019 e' il primo giorno del quarto trimestre del 2019,
 * cioe' il primo ottobre 2019.
 */
public class QuarterDate extends Date {
	
	/**
	 * I quattro trimestri di un anno.
	 */
	public enum Quarter {
		Q1, Q2, Q3, Q4
	};

	/**
	 * Numero di giorni in ciascun trimestre (Q1 -> Q4), senza considerare
	 * gli anni bisestili.
	 */
	private final static int daysInQuarter[] = { 90, 91, 92, 92 };

	/**
	 * Costruisce una data trimestrale.
	 * 
	 * @param day il giorno nel trimestre, da 1 a 92
	 * @param quarter il trimestre
	 * @param year l'anno, dal 1900 in poi
	 * @throws IllegalArgumentException se day/quarter/year non fosse una data valida
	 *                                  dal 1900 in poi, considerando anche gli anni bisestile
	 */
	public QuarterDate(int day, Quarter quarter, int year) {
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
	 * Restituisce il numero di giorni di un trimestre di un anno.
	 * Considera gli anni bisestili.
	 * 
	 * @param quarter il trimestre
	 * @param year l'anno, dal 1900 in poi
	 * @return 90, 91 o 92
	 */
	private static int daysInQuarter(Quarter quarter, int year) {
		if (quarter == Quarter.Q1 && isLeapYear(year))
			return 91;
		else
			return daysInQuarter[quarter.ordinal()];
	}

	/**
	 * Restituisce il numero di giorni dal 1 gennaio 1900 (incluso) a day/quarter/year (escluso).
	 * 
	 * @param day il giorno
	 * @param quarter il trimestre
	 * @param year l'anno
	 * @return il numero di giorni dall'1 gennaio 1900 (incluso) a day/quarter/year (escluso)
	 * @throws IllegalArgumentException se day/quarter/year non fosse una data valida,
	 *                                  considerando anche gli anni bisestile
	 */
	private static int daysAfterStartOf1900(int day, Quarter quarter, int year) {
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
	 * Restituisce il trimestre di questa data.
	 */
	private Quarter getQuarter() {
		int year = 1900;
		int remainingDays;
		for (remainingDays = daysAfterStartOf1900; remainingDays >= daysInYear(year); remainingDays -= daysInYear(year++)); 

		Quarter quarter;
		for (quarter = Quarter.Q1; remainingDays >= daysInQuarter(quarter, year); remainingDays -= daysInQuarter(quarter, year), quarter = Quarter.values()[quarter.ordinal() + 1]);

		return quarter;
	}

	/**
	 * Restituisce il giorno del trimestre di questa data.
	 * 
	 * @return da 1 a 92
	 */
	private int getDay() {
		int year = 1900;
		int remainingDays;
		for (remainingDays = daysAfterStartOf1900; remainingDays >= daysInYear(year); remainingDays -= daysInYear(year++)); 

		Quarter quarter;
		for (quarter = Quarter.Q1; remainingDays >= daysInQuarter(quarter, year); remainingDays -= daysInQuarter(quarter, year), quarter = Quarter.values()[quarter.ordinal() + 1]);

		return remainingDays + 1;
	}

	/**
	 * Restituisce una stringa che descrive questa data.
	 * 
	 * @return una stringa del tipo ggQQ aaaa, in cui giorno e' sempre su due cifre
	 *         e QQ e' il trimestre, da Q1 a Q4
	 */
	@Override
	public String toString() {
		return ""; // TODO
	}

	@Override
	public QuarterDate after(int days) {
		return null; // TODO
	}
}
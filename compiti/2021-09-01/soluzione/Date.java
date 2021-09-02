package it.univr.dates;

import java.util.Random;

/**
 * Questa e' una classe immutabile che rappresenta una data del calendario.
 * Quindi i suoi oggetti sono immutabili.
 */
public class Date {
	
	/**
	 * Il giorno della data.
	 */
	private final int day;

	/**
	 * Il mese della data.
	 */
	private final int month;

	/**
	 * L'anno della data.
	 */
	private final int year;

	/**
	 * Costruisce una data arbitraria.
	 * 
	 * @param day il giorno della data
	 * @param month il mese della data
	 * @param year l'anno della data
	 */
	public Date(int day, int month, int year) {
		if (1 <= month && month <= 12 && 1 <= day && day <= daysInMonth(month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else
			throw new IllegalArgumentException("day e month non sono legali");
	}

	/**
	 * Costruisce il primo giorno del mese indicato.
	 * 
	 * @param month il mese della data
	 * @param year l'anno della data
	 */
	public Date(int month, int year) {
		this(1, month, year); // delega al primo costruttore
	}

	/**
	 * Costruisce il primo gennaio dell'anno indicato.
	 * 
	 * @param year l'anno della data
	 */
	public Date(int year) {
		this(1, year);
	}

	/**
	 * Costruisce una data a caso tra il 2000 e il 2100.
	 */
	public Date() {
		Random random = new Random();
		this.month = 1 + random.nextInt(12);
		this.year = 2000 + random.nextInt(101);
		int days = daysInMonth(month, year);
		this.day = 1 + random.nextInt(days);
	}

	public Date next() {
		int day = this.day;
		int month = this.month;
		int year = this.year;

		if (day == daysInMonth(month, year)) {
			day = 1;
			month++;
			
			if (month == 13) {
				month = 1;
				year++;
			}
		}
		else
			day++;

		return new Date(day, month, year);
	}

	private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static int daysInMonth(int m, int y) {
		if (m == 2 && isLeapYear(y))
			return 29;

		return DAYS[m - 1];
	}

	private static boolean isLeapYear(int y) {
		return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
	}

	/**
	 * Restituisce una descrizione di questa data.
	 * 
	 * @return la descrizione, come stringa
	 */
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	/**
	 * Determina se other e' una data identica a questa.
	 */
	public boolean equals(Object other) {
		if (other instanceof Date) {
			Date otherAsDate = (Date) other;
			return day == otherAsDate.day && month == otherAsDate.month && year == otherAsDate.year;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return day ^ month ^ year;
	}

	/**
	 * Confronta questa data con un'altra data.
	 * 
	 * @param other l'altra data
	 * @return negativo, se this viene prima di other; positivo, se this viene
	 *         dopo di other, 0 se this e other sono equivalenti
	 */
	public int compareTo(Date other) {
		int diff = year - other.year;
		if (diff != 0)
			return diff;

		diff = month - other.month;
		if (diff != 0)
			return diff;

		return day - other.day;
	}
}
package it.univr.insurance;

import java.time.LocalDate;

/**
 * L'enumerazione delle quattro stagioni.
 * 
 * La classe di libreria LocalDate e' documentata qui:
 * https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/time/LocalDate.html
 * 
 * Considerate le stagioni in questo modo:
 * 
 * Primavera: dal 21 marzo fino a 20 giugno
 * Estate: dal 21 giugno fino a 22 settembre
 * Autunno: dal 23 settembre fino a 20 dicembre
 * Inverno: dal 21 dicembre fino a 20 marzo
 */
public enum Season {
	SPRING, SUMMER, FALL, WINTER; // primavera, estate, autunno, inverno

	public static void main(String[] args) {
		System.out.println(Season.now());
		System.out.println(Season.of(LocalDate.of(2021, 6, 21)));
	}

	/**
	 * Restituisce la stagione attuale.
	 */
	public static Season now() {
		return of(LocalDate.now());
	}

	/**
	 * Restituisce la stagione a cui appartiene il giorno indicato.
	 * 
	 * @param date il giorno
	 * @return la stagione a cui appartiene date
	 */
	public static Season of(LocalDate date) {
		int year = date.getYear();

		LocalDate startOfSpring = LocalDate.of(year, 3, 21);
		if (date.isBefore(startOfSpring))
			return WINTER;

		LocalDate startOfSummer = LocalDate.of(year, 6, 21);
		if (date.isBefore(startOfSummer))
			return SPRING;

		LocalDate startOfFall = LocalDate.of(year, 9, 23);
		if (date.isBefore(startOfFall))
			return SUMMER;

		LocalDate startOfWinter = LocalDate.of(year, 12, 21);
		if (date.isBefore(startOfWinter))
			return FALL;

		return WINTER;
	}
}
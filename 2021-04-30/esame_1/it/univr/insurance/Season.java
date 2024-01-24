package it.univr.insurance;

import java.time.LocalDate;

// SI COMPLETI DOVE INDICATO CON TODO
// 25 minuti

// SI CONSEGNI Season.java ALLEGANDOLO IN CHAT O INVIANDOLO A fausto.spoto@univr.it

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
	// TODO
	// primavera, estate, autunno, inverno

	// un punto e virgola separa gli elementi dell'enumerazione
	// dai metodi dell'enumerazione
	;

	public static void main(String[] args) {
		System.out.println(Season.now()); // stampa la stagione attuale
		System.out.println(Season.of(LocalDate.of(2021, 6, 21))); // stampa SUMMER
	}

	/**
	 * Restituisce la stagione attuale.
	 */
	public static Season now() {
		return null; // TODO
	}

	/**
	 * Restituisce la stagione a cui appartiene il giorno indicato.
	 * 
	 * @param date il giorno
	 * @return la stagione a cui appartiene date
	 */
	public static Season of(LocalDate date) {
		return null; // TODO
	}
}
package it.univr.rent;

/**
 * I modelli sono ordinati per prezzo di noleggio giornaliero.
 * A parita' di prezzo di noleggio, sono ordinati alfabeticamente per nome.
 */
public interface Model extends Comparable<Model> {
	// restituisce il nome del modello
	public String getName();

	// determina se il modello puo' essere guidato
	// con la patente (license) indicata
	public boolean canBeDrivenWith(License license);

	// restituisce il prezzo giornaliero di noleggio del modello
	public int pricePerDay();
}